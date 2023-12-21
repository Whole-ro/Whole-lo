package test;


import java.util.List;

import model.dao.mybatis.WithwithMapperRepository;
import model.entity.UserEntity;

public class WithwithTest {
	private static WithwithMapperRepository dao = new WithwithMapperRepository();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		List<UserEntity> list = dao.selectUserByInterest("운동", 6);
		
		for(UserEntity user : list) {
			System.out.println(user.getNickname());
		}
	}

}
