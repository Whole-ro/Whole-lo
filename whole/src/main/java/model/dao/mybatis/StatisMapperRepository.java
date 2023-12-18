package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.dao.mybatis.mapper.StatisticsMapper;
import model.dto.FoodDTO;

public class StatisMapperRepository {

	private SqlSessionFactory sqlSessionFactory;
	
	public StatisMapperRepository() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//USERID로 빨간유형의 음식수 검색
	public List<FoodDTO> selectRedByUserId(Long userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(StatisticsMapper.class).selectRedByUserId(userId);
		} finally {
			sqlSession.close();
		}
	}
	
	//USERID로 파란유형의 음식수 검색
	public List<FoodDTO> selectBlueByUserId(Long userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(StatisticsMapper.class).selectBlueByUserId(userId);
		} finally {
			sqlSession.close();
		}
	}
	//USERID로 빨간유형의 음식수 세기
	public int countRedByUserId(Long userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(StatisticsMapper.class).countRedByUserId(userId);
		} finally {
			sqlSession.close();
		}
	}
	
	//USERID로 파란유형의 음식수 세기
	public int countBlueByUserId(Long userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(StatisticsMapper.class).countBlueByUserId(userId);
		} finally {
			sqlSession.close();
		}
	}
	//USERID로 가장 많이 먹은 음식유형
	public String findMostFoodType(Long userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(StatisticsMapper.class).findMostFoodType(userId);
		} finally {
			sqlSession.close();
		}
	}
	//유저가 먹었던 음식들 중 BLUE유형의 음식 검색
	public String findMyBLUETypeFood(Long userId){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(StatisticsMapper.class).findMyBLUETypeFood(userId);
		} finally {
			sqlSession.close();
		}
		
	}
}
