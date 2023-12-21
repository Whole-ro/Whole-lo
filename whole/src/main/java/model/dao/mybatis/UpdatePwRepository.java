package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.dao.mybatis.mapper.StatisticsMapper;
import model.dao.mybatis.mapper.UpdatePwMapper;
import model.entity.UserEntity;

public class UpdatePwRepository {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UpdatePwRepository() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public int updatePw(String newpw, Long userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			 UpdatePwMapper updatePwMapper = sqlSession.getMapper(UpdatePwMapper.class);
		        int result = updatePwMapper.updatepwByUserId(newpw, userId);
		        sqlSession.commit();
		        // Log the result
		        System.out.println("result: "+result);

		        return result;
		} finally {
			sqlSession.close();
		}
	}

}
