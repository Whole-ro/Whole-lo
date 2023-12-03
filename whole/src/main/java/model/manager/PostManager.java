package model.manager;

import java.sql.SQLException;

import model.dao.MarketDAO;
import model.entity.ItemEntity;

public class PostManager {
   private static PostManager postMan = new PostManager();
   private MarketDAO marketDAO;
   
   private PostManager() {
	   try {
		      marketDAO = new MarketDAO();
		   } catch (Exception e) {
		      System.err.println("PostManager 초기화 중 오류 발생: " + e.getMessage());
		      e.printStackTrace();
		      // 예외를 더 적절하게 처리하거나 다시 던질 수 있음
		      // 예를 들어, RuntimeException 으로 감싸거나 로깅 후 종료 등
		      throw new RuntimeException("PostManager 초기화 중 오류 발생", e);
		   }
   }
   
   public static PostManager getInstance() {
      return postMan;
   }
   
   public ItemEntity findItem(String postId) throws SQLException {
      Long id = Long.parseLong(postId);
      ItemEntity item = marketDAO.findItem(id);
      if (item == null) {
          System.out.println("item이 null");
          return null;
      }
      return item;
   }
}
