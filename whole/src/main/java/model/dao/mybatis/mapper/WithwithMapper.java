package model.dao.mybatis.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.dto.FoodDTO;
import model.entity.UserEntity;
public interface WithwithMapper {
	
	@Select({"SELECT nickname FROM USER_TABLE WHERE interest = #{interest}"})
	List<UserEntity> selectUserByInterest(String interest);
}
