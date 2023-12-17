package model.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.dto.FoodDTO;

public interface StatisticsMapper {
	@Select({ "SELECT title\r\n"
			+ "FROM FOOD\r\n"
			+ "JOIN POST USING (post_id)\r\n"
			+ "WHERE is_healthy = 'BLUE'\r\n"
			+ "ORDER BY DBMS_RANDOM.VALUE\r\n"
			+ "FETCH FIRST 5 ROWS ONLY" })
	List<FoodDTO> selectBluetypeFood();
}
