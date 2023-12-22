package test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.dao.*;
import model.dao.mybatis.StatisMapperRepository;
import model.dto.FoodDTO;
import model.entity.FoodEntity;
import util.FoodTypeUtil;
import model.dao.mybatis.StatisMapperRepository;
//
//
public class FoodTest {
//
	private static FoodDAO foodDao = new FoodDAO();
	@SuppressWarnings("null")
//	
//
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
//
//
		List<FoodDTO> foodList = foodDao.findFoodList();
		
		Iterator<FoodDTO> iter = foodList.iterator();

        System.out.println("post_id        title           image          exp_date         reg_date");

        System.out.println("-----------------------------------------------------------------------");

        while(iter.hasNext()) {
////
        	FoodDTO food = iter.next();
////
            System.out.println(food.getTitle()+"postID: "+food.getPostId());
////
        }
        
       // int cnt = foodDao.removeFoodByPostId(5);
////
       // System.out.println(cnt);
        
        System.out.println("삭제 후");
        //foodList = foodDao.findFoodListByExpDate();
		
		iter = foodList.iterator();

        System.out.println("post_id        title           image          exp_date         reg_date");

        System.out.println("-----------------------------------------------------------------------");

        while(iter.hasNext()) {
////
        	FoodDTO food = iter.next();
////
            System.out.println(food.getTitle()+"postID: "+food.getExpDate());
////
        }
        
        scanner.close();
	}

}
