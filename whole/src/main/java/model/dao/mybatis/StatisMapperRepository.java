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
	
	public List<FoodDTO> selectRedByUserId(Long userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(StatisticsMapper.class).selectRedByUserId(userId);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<FoodDTO> selectBlueByUserId(Long userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(StatisticsMapper.class).selectBlueByUserId(userId);
		} finally {
			sqlSession.close();
		}
	}
	
	public int countRedByUserId(Long userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(StatisticsMapper.class).countRedByUserId(userId);
		} finally {
			sqlSession.close();
		}
	}
}
