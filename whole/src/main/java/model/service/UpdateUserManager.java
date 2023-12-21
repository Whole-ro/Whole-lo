package model.service;

import model.dao.mybatis.UpdatePwRepository;
import model.entity.UserEntity;

public class UpdateUserManager {
	
	private static UpdateUserManager updateuserMan = new UpdateUserManager();
	private UpdatePwRepository updatepwRepository;
	
	private UpdateUserManager() {
		try {
			updatepwRepository = new UpdatePwRepository();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static UpdateUserManager getInstance() {
		return updateuserMan;
	}
	
	public int updatePw(String newpw, Long userId) {
		return updatepwRepository.updatePw(newpw, userId);
	}
}
