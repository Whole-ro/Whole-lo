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
import util.FoodTypeUtil;


public class StatisMapperRepository {

   private SqlSessionFactory sqlSessionFactory;
   private FoodTypeUtil foodtypeutil = new FoodTypeUtil();
   
   
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
   
   public List<FoodDTO> findBluetypeFood() {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   try {
		   return sqlSession.getMapper(StatisticsMapper.class).selectBluetypeFood();
	   }
	   finally {
		   sqlSession.close();}
 		
 	}
   
}