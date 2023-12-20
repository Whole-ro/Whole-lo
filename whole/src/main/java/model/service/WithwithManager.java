package model.service;

import java.util.List;

import model.dao.mybatis.StatisMapperRepository;
import model.dao.mybatis.WithwithMapperRepository;
import model.dto.FoodDTO;
import model.entity.UserEntity;

public class WithwithManager {
	private static WithwithManager withWithMan = new WithwithManager(); 
	private WithwithMapperRepository withWithRepository;
	
	private WithwithManager() {
		try {
			withWithRepository = new WithwithMapperRepository();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static WithwithManager getInstance() {
		return withWithMan;
	}
	
	
	public List<UserEntity> findUserByInterest(String interest, long userId) {
		return withWithRepository.selectUserByInterest(interest, userId);
	}
}
