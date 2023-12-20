package model.dao.mybatis.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.dto.FoodDTO;
import model.entity.UserEntity;
public interface WithwithMapper {
	
	@Select({"SELECT nickname, address, introduction FROM USER_TABLE WHERE interest = #{interest} AND user_id != #{userId}"})
	List<UserEntity> selectUserByInterest(
			@Param("interest")String interest, 
			@Param("userId") long userId);
}
