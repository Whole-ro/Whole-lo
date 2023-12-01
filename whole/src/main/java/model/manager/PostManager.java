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
      } catch (Exception e) {e.printStackTrace();}
   }
   
   public static PostManager getInstance() {
      return postMan;
   }
   
   public ItemEntity findItem(String postId) throws SQLException {
      Long id = Long.parseLong(postId);
      ItemEntity item = marketDAO.findItem(id);
      return item;
   }
}