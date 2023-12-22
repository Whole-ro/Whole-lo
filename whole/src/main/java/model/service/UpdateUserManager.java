package model.service;

import model.dao.mybatis.UpdatePwRepository;
import model.entity.UserEntity;

public class UpdateUserManager {
	
	private static UpdateUserManager updateuserMan = new UpdateUserManager();
	private UpdatePwRepository updatepwDAO;
	
	private UpdateUserManager() {
		try {
			updatepwDAO = new UpdatePwRepository();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static UpdateUserManager getInstance() {
		return updateuserMan;
	}
	
	public int updatePw(String newpw, Long userId) {
		return updatepwDAO.updatePw(newpw, userId);
	}
}
