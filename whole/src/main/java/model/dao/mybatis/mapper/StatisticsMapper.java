package model.dao.mybatis.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.dto.FoodDTO;
public interface StatisticsMapper {
	
	@Select({"SELECT title FROM FOOD JOIN POST USING (post_id) WHERE is_healthy = 'RED' AND writer_id = #{userId}"})
	List<FoodDTO> selectRedByUserId(Long userId);
	
	@Select({"SELECT title FROM FOOD JOIN POST USING (post_id) WHERE is_healthy = 'BLUE' AND writer_id = #{userId}"})
	List<FoodDTO> selectBlueByUserId(Long userId);
	
	@Select({"SELECT COUNT(*) as cnt FROM FOOD JOIN POST USING (post_id) WHERE is_healthy = 'RED' AND writer_id = #{userId}"})
	int countRedByUserId(Long userId);
	
	@Select({"SELECT COUNT(*) as cnt FROM FOOD JOIN POST USING (post_id) WHERE is_healthy = 'BLUE' AND writer_id = #{userId}"})
	int countBlueByUserId(Long userId);
	
	@Select({"SELECT food_type\r\n"
			+ "FROM (SELECT food_type FROM FOOD JOIN POST USING (post_id) WHERE writer_id = #{userId} GROUP BY food_type ORDER BY COUNT(food_type) DESC)\r\n"
			+ "WHERE ROWNUM = 1"})
	String findMostFoodType(Long userId);
	
	@Select({"SELECT  p.title \r\n"
			+ "FROM POST p \r\n"
			+ "    JOIN user_table u ON u.user_id = p.writer_id AND u.user_id = #{userId}\r\n"
			+ "    JOIN FOOD f ON f.post_id = p.post_id AND f.is_healthy = 'BLUE'"})
	List<String> findMyBLUETypeFood(Long userId);
	
	
	@Select({"SELECT  p.title \r\n"
			+ "FROM POST p \r\n"
			+ "    JOIN user_table u ON u.user_id = p.writer_id AND u.user_id = #{userId}\r\n"
			+ "    JOIN FOOD f ON f.post_id = p.post_id AND f.is_healthy = 'RED'"})
	List<String> findMyREDTypeFood(Long userId);
}
