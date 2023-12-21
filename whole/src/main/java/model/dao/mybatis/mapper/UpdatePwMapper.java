package model.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Update;

import model.entity.UserEntity;
public interface UpdatePwMapper {

		@Update({"Update user_table SET password = #{newpw} WHERE user_id = #{userId}"})
		public int updatepwByUserId(String newpw, Long userId);
	
}


