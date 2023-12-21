package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.dao.mybatis.mapper.StatisticsMapper;
import model.dao.mybatis.mapper.WithwithMapper;
import model.dto.FoodDTO;
import model.entity.UserEntity;

public class WithwithMapperRepository {

	private SqlSessionFactory sqlSessionFactory;
	
	public WithwithMapperRepository() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public List<UserEntity> selectUserByInterest(String interest, long userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(WithwithMapper.class).selectUserByInterest(interest, userId);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<UserEntity> selectUserByGender(String interest, long userId, String gender) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(WithwithMapper.class).selectUserByGender(gender, interest, userId);
		} finally {
			sqlSession.close();
		}
	}
}
