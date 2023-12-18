package model.service;

import java.util.List;

import model.dao.mybatis.StatisMapperRepository;
import model.dto.FoodDTO;

public class StatisticsManager {
	private static StatisticsManager statisticsMan = new StatisticsManager(); 
	private StatisMapperRepository statisticsRepository;
	
	private StatisticsManager() {
		try {
			statisticsRepository = new StatisMapperRepository();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static StatisticsManager getInstance() {
		return statisticsMan;
	}
	
	public List<FoodDTO> selectRedByUserId(Long userId){
		return statisticsRepository.selectRedByUserId(userId);
	}
	
	public List<FoodDTO> selectBlueByUserId(Long userId) {
		return statisticsRepository.selectBlueByUserId(userId);
	} 
	
	public int countRedByUserId(Long userId) {
		return statisticsRepository.countRedByUserId(userId);
	}
	
	public int countBlueByUserId(Long userId) {
		return statisticsRepository.countBlueByUserId(userId);
	}
	
	public String findMostFoodType(Long userId) {
		return statisticsRepository.findMostFoodType(userId);
	}
}
