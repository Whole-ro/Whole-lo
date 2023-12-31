package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.mybatis.StatisMapperRepository;
import model.dto.FoodDTO;

public class FoodstaticsManager {

	private static FoodstaticsManager fstaticsMan = new FoodstaticsManager();
	private StatisMapperRepository statismapperDAO;

	private FoodstaticsManager() {
		try {
			statismapperDAO = new StatisMapperRepository();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static FoodstaticsManager getInstance() {
		return fstaticsMan;
	}

	public List<String> viewstaticlist(Long userId) throws SQLException {
		return statismapperDAO.findMyBLUETypeFood(userId);
	}
	
	//유저가 먹은 빨간색음식리스트 DAO의 메서드 추출
	public List<String> viewstaticRedlist(Long userId) throws SQLException {
		return statismapperDAO.findMyREDTypeFood(userId);
	}

}
