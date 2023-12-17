package model.dao.mybatis.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.dto.FoodDTO;
public interface StatisticsMapper {
	
	@Select({"SELECT title FROM FOOD JOIN POST USING (post_id) WHERE is_healthy = 'RED'"})
	List<FoodDTO> selectRedByUserId(Long userId);
	
	@Select({"SELECT title FROM FOOD JOIN POST USING (post_id) WHERE is_healthy = 'BLUE'"})
	List<FoodDTO> selectBlueByUserId(Long userId);
	
	@Select({"SELECT COUNT(*) as cnt FROM FOOD JOIN POST USING (post_id) WHERE is_healthy = 'RED'"})
	int countRedByUserId(Long userId);
	
}
