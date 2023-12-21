package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Community;
import model.enums.IsHealthy;
import model.dto.FoodDTO;
import model.entity.FoodEntity;

public class FoodDAO {
	private JDBCUtil jdbcUtil = null;

	public FoodDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	/**
	 *  테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public FoodDTO createFood(FoodDTO foodDto) throws SQLException {
	    /* post에 insert */
	    String sql1 = "INSERT INTO POST VALUES (SEQUENCE_POSTID.nextval, ?, 'MY_REFRIGERATOR',"
	    		+ " ?, ?, SYSDATE, ?)";
	    Object[] param1 = new Object[]{foodDto.getTitle(), foodDto.getContent(),
	            foodDto.getImage(), foodDto.getWriterId()};
	    jdbcUtil.setSqlAndParameters(sql1, param1);    // JDBCUtil 에 insert문과 매개 변수 설정

	    String key[] = {"post_id"};    // PK 컬럼의 이름     
	    
	    try {
	        jdbcUtil.executeUpdate(key);  // insert 문 실행
	        ResultSet rs = jdbcUtil.getGeneratedKeys();
	        if (rs.next()) {
	            Long generatedKey = rs.getLong(1);   // 생성된 PK 값
	            foodDto.setPostId(generatedKey);  // id필드에 저장 
	            String sql2 = "INSERT INTO FOOD VALUES (SEQUENCE_POSTID.currval, ?, ?, ?)";
	            String color = getFoodColor(foodDto.getFoodType()).toString();
	            Object[] param2 = new Object[]{foodDto.getFoodType(), foodDto.getExpDate(), color};
	            jdbcUtil.setSqlAndParameters(sql2, param2);    // JDBCUtil 에 insert문과 매개 변수 설정
	            jdbcUtil.executeUpdate();
	        }
	        return foodDto;
	    } catch (Exception ex) {
	        jdbcUtil.rollback();
	        ex.printStackTrace();
	    } finally {        
	        jdbcUtil.commit();
	        jdbcUtil.close();    // resource 반환
	    }        
	    
        return null;            
	}

	/*음식 삭제*/
	public int removeFoodByPostId(long postId) throws SQLException {
        System.out.println("여기는 DAO");

		String sql = "DELETE FROM POST WHERE post_id=?";		
        System.out.println("여기는 DAO2");

		jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});	// JDBCUtil에 delete문과 매개 변수 설정
        System.out.println("여기는 DAO3");

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
	         System.out.println(result);
			return result;
		} catch (Exception ex) {
	          System.out.println("exception");

			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
            System.out.println("finally");

			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
        System.out.println("여기는 DAO 4");

		return 0;
	}
	
	public IsHealthy getFoodColor(String foodType) {
		String[] red = {"간편식", "분식", "과자", "초콜릿", "아이스크림", "소스", "커피",
				"빵", "떡", "잼"};
		for (String s : red) {
		    if (foodType.equals(s)) {
				return IsHealthy.RED;
		    }
		}
		return IsHealthy.BLUE;
	}
	/**
	 * 음식 수정
	 */
	public int updateFoodByPostId(FoodDTO foodDto) {
		String sql1 = "UPDATE POST "
				+"SET title=?, content=?, image=? "
				+ "WHERE post_id = ?";
		Object[] param1 = new Object[] {foodDto.getTitle(), foodDto.getContent(),
				foodDto.getImage(), foodDto.getPostId()};
	
		jdbcUtil.setSqlAndParameters(sql1, param1);	// JDBCUtil에 update문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}
		
		String sql2 = "UPDATE FOOD "
				+ "SET food_type=?, exp_date=?, is_healthy=? "
				+ "WHERE post_id = ?";

		String color = getFoodColor(foodDto.getFoodType()).toString();
		Object[] param2 = new Object[] {foodDto.getFoodType(), foodDto.getExpDate(),
				color, foodDto.getPostId()};
		jdbcUtil.setSqlAndParameters(sql2, param2);	// JDBCUtil에 update문과 매개 변수 설정
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}
		return 0;
	}

	//***************음식명으로 검색*********************
	public List<FoodDTO> findFoodByTitle(String title) throws SQLException {
		String sql = "SELECT post_id, title, image, exp_date, reg_date, food_type "
				+ "FROM FOOD JOIN POST USING (post_id) "
				+ "WHERE title=? "
				+ "ORDER BY reg_date"; 
		jdbcUtil.setSqlAndParameters(sql, new Object[] {title});	// JDBCUtil에 query문과 매개 변수 설정
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<FoodDTO> foodList = new ArrayList<FoodDTO>();	// foodList들의 리스트 생성
			while (rs.next()) {
				FoodDTO food = new FoodDTO();
				food.setPostId(rs.getLong("post_id"));// Food 객체를 생성하여 현재 행의 정보를 저장
				food.setTitle(rs.getString("title"));
				food.setImage(rs.getString("image"));
				food.setExpDate(rs.getDate("exp_date").toLocalDate());
				food.setRegDate(rs.getDate("reg_date").toLocalDate());
				food.setFoodType(rs.getString("food_type"));
				foodList.add(food);				// List에 Food 객체 저장
			}		
			return foodList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	//***************음식 타입으로 검색*********************
	public List<FoodDTO> findFoodByFoodType(String foodType) throws SQLException {
		String sql = "SELECT post_id, title, image, exp_date, reg_date "
				+ "FROM FOOD JOIN POST USING (post_id) "
				+ "WHERE food_type=? "
				+ "ORDER BY reg_date"; 
		jdbcUtil.setSqlAndParameters(sql, new Object[] {foodType});	// JDBCUtil에 query문과 매개 변수 설정
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<FoodDTO> foodList = new ArrayList<FoodDTO>();	// foodList들의 리스트 생성
			while (rs.next()) {
				FoodDTO food = new FoodDTO();
				food.setPostId(rs.getLong("post_id"));// Food 객체를 생성하여 현재 행의 정보를 저장
				food.setTitle(rs.getString("title"));
				food.setImage(rs.getString("image"));
				food.setExpDate(rs.getDate("exp_date").toLocalDate());
				food.setRegDate(rs.getDate("reg_date").toLocalDate());
				foodList.add(food);				// List에 Food 객체 저장
			}		
			return foodList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 주어진  ID에 해당하는 음식 정보를 데이터베이스에서 찾아 Food 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public FoodDTO findFood(long postId) throws SQLException {
		String sql = "SELECT title, exp_date, content, image, food_type "
				+ "FROM FOOD JOIN POST USING (post_id) "
				+ "WHERE post_id=? "
				+ "ORDER BY reg_date"; 
		jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});	// JDBCUtil에 query문과 매개 변수 설정
		FoodDTO food = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				food = new FoodDTO();
				food.setTitle(rs.getString("title"));
				food.setExpDate(rs.getDate("exp_date").toLocalDate());
				food.setContent(rs.getString("content"));
				food.setImage(rs.getString("image"));
				food.setFoodType(rs.getString("food_type"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return food;
	}

	public List<FoodDTO> findFoodList() throws SQLException {
		//나의 냉장고 확인 화면
		String sql = "SELECT post_id, title, image, exp_date, reg_date, food_type "
				+ "FROM FOOD JOIN POST USING (post_id) "
				+ "ORDER BY reg_date";        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<FoodDTO> foodList = new ArrayList<FoodDTO>();	// foodList들의 리스트 생성
			while (rs.next()) {
				FoodDTO food = new FoodDTO();
				food.setPostId(rs.getLong("post_id"));// Food 객체를 생성하여 현재 행의 정보를 저장
				food.setTitle(rs.getString("title"));
				food.setImage(rs.getString("image"));
				food.setExpDate(rs.getDate("exp_date").toLocalDate());
				food.setRegDate(rs.getDate("reg_date").toLocalDate());
				food.setFoodType(rs.getString("food_type"));
				foodList.add(food);				// List에 Food 객체 저장
			}		
			return foodList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/*userId 별 음식 출력 */
	public List<FoodDTO> findFoodListByUserId(long userId) throws SQLException {
		//나의 냉장고 확인 화면
		String sql = "SELECT post_id, title, image, exp_date, reg_date, food_type "
				+ "FROM FOOD JOIN POST USING (post_id) WHERE writer_id =?"
				+ "ORDER BY reg_date";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});// JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<FoodDTO> foodList = new ArrayList<FoodDTO>();	// foodList들의 리스트 생성
			while (rs.next()) {
				FoodDTO food = new FoodDTO();
				food.setPostId(rs.getLong("post_id"));// Food 객체를 생성하여 현재 행의 정보를 저장
				food.setTitle(rs.getString("title"));
				food.setImage(rs.getString("image"));
				food.setExpDate(rs.getDate("exp_date").toLocalDate());
				food.setRegDate(rs.getDate("reg_date").toLocalDate());
				food.setFoodType(rs.getString("food_type"));
				foodList.add(food);				// List에 Food 객체 저장
			}		
			return foodList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/* 유통기한 3일 남은 음식 List 반환*/
	public List<FoodDTO> findFoodListByExpDate() throws SQLException {
		//나의 냉장고 확인 화면
		String sql = "SELECT post_id, title, image, exp_date, reg_date, food_type "
				+ "FROM FOOD JOIN POST USING (post_id) "
				+ "WHERE (exp_date - SYSDATE) < 3 "
				+ "ORDER BY reg_date";        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<FoodDTO> foodList = new ArrayList<FoodDTO>();	// foodList들의 리스트 생성
			while (rs.next()) {
				FoodDTO food = new FoodDTO();
				food.setPostId(rs.getLong("post_id"));// Food 객체를 생성하여 현재 행의 정보를 저장
				food.setTitle(rs.getString("title"));
				food.setImage(rs.getString("image"));
				food.setExpDate(rs.getDate("exp_date").toLocalDate());
				food.setRegDate(rs.getDate("reg_date").toLocalDate());
				food.setFoodType(rs.getString("food_type"));
				foodList.add(food);				// List에 Food 객체 저장
			}		
			return foodList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}