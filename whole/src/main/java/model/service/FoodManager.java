package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.FoodDAO;
import model.dao.UserDAO;
import model.dto.FoodDTO;
import model.entity.FoodEntity;
import model.entity.UserEntity;
import model.enums.IsHealthy;

public class FoodManager {
    
    private static FoodManager foodMan = new FoodManager();
    private FoodDAO foodDAO;
//  private CommunityDAO commDAO;
//  private UserAnalysis userAanlysis;
//
    private FoodManager() {
        try {
            foodDAO = new FoodDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    
    public static FoodManager getInstance() {
        return foodMan;
    }
    
    
    public FoodDTO createFood(FoodDTO foodDTO) throws SQLException {
       
        return foodDAO.createFood(foodDTO);
    }
    
//    public int removeFoodByPostId(int postId) throws SQLException {
    public int removeFood(long postId) throws SQLException {
        return foodDAO.removeFoodByPostId(postId);
    }
    

//    public int updateFoodByPostId(FoodDTO foodDto) {
    public int updateFood(FoodDTO foodDto) throws SQLException {
        return foodDAO.updateFoodByPostId(foodDto);
    }
    
//        public List<FoodEntity> findFoodByTitle(String title) throws SQLException {
    public List<FoodDTO> searchByTitle(String title) throws SQLException{
        return foodDAO.findFoodByTitle(title);
    }
    
    //public List<FoodDTO> findFoodList() throws SQLException {
    public List<FoodDTO> findFoodList() throws SQLException{
        return foodDAO.findFoodList();
    }
    
//            public List<FoodEntity> findFoodByFoodType(String foodType) throws SQLException {
//                
    public List<FoodDTO> searchByType(String title) throws SQLException{
        return foodDAO.findFoodByFoodType(title);
    }
    
//    public List<FoodEntity> findFoodListByExpDate() throws SQLException {
    public List<FoodDTO> clickExpDate() throws SQLException{
        return foodDAO.findFoodListByExpDate();
    }

}
