package model.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.dto.FoodDTO;

public interface StatisticsMapper {
//	user 6이 먹었던 음식 select해서 그거는 빼고 5개 추려서 화면에 뿌려주기
	
	//user6이 먹었던 음식 중 is_healty가 BLUE인 경우
	@Select({ "SELECT u.user_id , p.title , f.is_healthy\r\n"
			+ "FROM POST p \r\n"
			+ "    JOIN user_table u ON u.user_id = p.writer_id AND u.user_id = 6\r\n"
			+ "    JOIN FOOD f ON f.post_id = p.post_id AND f.is_healthy = 'BLUE'" })
	
	List<FoodDTO> selectBluetypeFood();
}
