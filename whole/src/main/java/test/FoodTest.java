package test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.dao.*;
import model.dao.mybatis.StatisMapperRepository;
import model.dto.FoodDTO;
import model.entity.FoodEntity;


public class FoodTest {

	private static FoodDAO foodDao = new FoodDAO();

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);


		List<FoodDTO> foodList = foodDao.findFoodList();
		// empList에 포함된 모든 emp 객체들의 필드 값을 출력 

		// emp 객체들을 하나씩 접근하기 위해 empList로부터 Iterator<Employee>를 구해서 활용

		Iterator<FoodDTO> iter = foodList.iterator();



		System.out.println("post_id        title           image          exp_date         reg_date");

		System.out.println("-----------------------------------------------------------------------");

		while(iter.hasNext()) {

			FoodDTO food = iter.next();

			System.out.println(food.getTitle()+food.getFoodType()+food.getContent()+food.getImage()+food.getPostId());

		}

		System.out.println("Red음식");

		StatisMapperRepository statisDao = new StatisMapperRepository();
		foodList = statisDao.selectRedByUserId((long) 6);

		iter = foodList.iterator();



		System.out.println("post_id        title           image          exp_date         reg_date");

		System.out.println("-----------------------------------------------------------------------");

		while(iter.hasNext()) {

			FoodDTO food = iter.next();

			System.out.println(food.getTitle()+food.getFoodType()+food.getContent()+food.getImage()+food.getPostId()+food.getWriterId());

		}
		int red_count = statisDao.countRedByUserId((long)6);
		System.out.println("RedFood : " + red_count);
		
		
		foodList = statisDao.selectBlueByUserId((long) 6);

		iter = foodList.iterator();

		System.out.println("Blue음식");

		System.out.println("post_id        title           image          exp_date         reg_date");

		System.out.println("-----------------------------------------------------------------------");

		while(iter.hasNext()) {

			FoodDTO food = iter.next();

			System.out.println(food.getTitle()+food.getFoodType()+food.getContent()+food.getImage()+food.getPostId());

		}    
		int blue_count = statisDao.countBlueByUserId((long)6);
		System.out.println("RedFood : " + blue_count);
		//
		//        // newMgr의 필드 값 출력 
		//
		//        System.out.printf("%d %s %s %s %.2f %.2f %d\n", 
		//
		//                newMgr.getEmpno(), newMgr.getEname(), newMgr.getJob(),
		//
		//                newMgr.getHiredate(), newMgr.getSal(), newMgr.getComm(), newMgr.getDeptNo());
		//
		// 
		
		String most = statisDao.findMostFoodType((long)6);
		System.out.println("MostFood : " + most);

		scanner.close();
		
		
	}

}
