package test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 4a60ce7093d43bd8f5123fc8fcb4c11c7c1e65bd
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.dao.*;
import model.dao.mybatis.StatisMapperRepository;
import model.dto.FoodDTO;
import model.entity.FoodEntity;
import util.FoodTypeUtil;
import model.dao.mybatis.StatisMapperRepository;


public class FoodTest {

	private static FoodDAO foodDao = new FoodDAO();

	@SuppressWarnings("null")
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);


		List<FoodDTO> foodList = foodDao.findFoodList();
		// empList에 포함된 모든 emp 객체들의 필드 값을 출력 

		// emp 객체들을 하나씩 접근하기 위해 empList로부터 Iterator<Employee>를 구해서 활용

<<<<<<< HEAD
//        List<FoodDTO> foodList = foodDao.findFoodList();
        // empList에 포함된 모든 emp 객체들의 필드 값을 출력 
=======
		Iterator<FoodDTO> iter = foodList.iterator();
>>>>>>> 4a60ce7093d43bd8f5123fc8fcb4c11c7c1e65bd


<<<<<<< HEAD
//        Iterator<FoodDTO> iter = foodList.iterator();
=======
>>>>>>> 4a60ce7093d43bd8f5123fc8fcb4c11c7c1e65bd

		System.out.println("post_id        title           image          exp_date         reg_date");

<<<<<<< HEAD
//        System.out.println("post_id        title           image          exp_date         reg_date");
//
//        System.out.println("-----------------------------------------------------------------------");
//
//        while(iter.hasNext()) {
//
//        	FoodDTO food = iter.next();
//
//            System.out.println(food.getTitle());
//
//        }
//
//        System.out.println();
//
//        FoodDTO food = new FoodDTO();
//        food.setTitle("도라지");
//        food.setContent("도라지입니다");
//        food.setFoodType("채소");
//        LocalDate expDate = LocalDate.parse("2023-12-20", DateTimeFormatter.ISO_DATE);
//        food.setExpDate(expDate);
//        food.setWriterId((long) 6);
//        
//        foodDao.createFood(food);
//      
//        FoodDTO food2 = new FoodDTO();
//        food.setTitle("떡볶이");
//        food.setContent("떡볶이입니다");
//        food.setFoodType("분식");
//        LocalDate expDate1 = LocalDate.parse("2023-12-20", DateTimeFormatter.ISO_DATE);
//        food.setExpDate(expDate1);
//        food.setWriterId((long) 6);
//        
//        foodDao.createFood(food);

//        System.out.print("새 관리자 사번과 관리자 보직수당을 입력하시오: ");
//
//        int managerNo  = scanner.nextInt();
//
//        double commission = scanner.nextDouble();
//
//        
//
//        Appointment appo = new Appointment(dept.getDeptNo(), managerNo, commission);
//
//        Employee oldMgr = compDao.replaceManagerOfDept(appo);    
//
//     
//
//        System.out.println("기존 관리자:");     
//
//        // oldMgr의 필드 값 출력
//
//        System.out.printf("%d %s %s %s %.2f %.2f %d\n",
//
//                oldMgr.getEmpno(), oldMgr.getEname(), oldMgr.getJob(),
//
//                oldMgr.getHiredate(), oldMgr.getSal(), oldMgr.getComm(), oldMgr.getDeptNo());
//
//        
//
//        Employee newMgr = compDao.findEmployee(managerNo);   
//
//        System.out.println("새 관리자:");         
//
//        // newMgr의 필드 값 출력 
//
//        System.out.printf("%d %s %s %s %.2f %.2f %d\n", 
//
//                newMgr.getEmpno(), newMgr.getEname(), newMgr.getJob(),
//
//                newMgr.getHiredate(), newMgr.getSal(), newMgr.getComm(), newMgr.getDeptNo());
//
// 
        FoodTypeUtil foodtypeUtil = new FoodTypeUtil();
        String []greenfoodarr = foodtypeUtil.greenFood;
        List<String> foods = new ArrayList<>();
        List<String> mygreenfood = new ArrayList<>();;

        StatisMapperRepository statisDao = new StatisMapperRepository();
        List<FoodDTO>foodList =statisDao.findBluetypeFood();
        Iterator<FoodDTO> iters = foodList.iterator();
        //food 유형이 BLUE인 음식만 가져옴
        	while(iters.hasNext()) {
        		FoodDTO food = iters.next();
        		mygreenfood.add(food.getTitle());
        		System.out.println(food.getTitle());
        	}
 	
       	System.out.println(mygreenfood);
//            System.out.println();


//        System.out.println(foods);
        scanner.close();
=======
		System.out.println("-----------------------------------------------------------------------");

		while(iter.hasNext()) {

			FoodDTO food = iter.next();

			System.out.println(food.getTitle()+food.getFoodType()+food.getContent()+food.getImage()+food.getPostId());

		}

		System.out.println("Red음식");

		StatisMapperRepository statisDao = new StatisMapperRepository();
		foodList = statisDao.selectRedByUserId((long) 6);

		iter = foodList.iterator();



		System.out.println("post_id        title           image          exp_date         reg_date");

		System.out.println("-----------------------------------------------------------------------");

		while(iter.hasNext()) {

			FoodDTO food = iter.next();

			System.out.println(food.getTitle()+food.getFoodType()+food.getContent()+food.getImage()+food.getPostId()+food.getWriterId());

		}
		int red_count = statisDao.countRedByUserId((long)6);
		System.out.println("RedFood : " + red_count);
		
		
		foodList = statisDao.selectBlueByUserId((long) 6);

		iter = foodList.iterator();

		System.out.println("Blue음식");

		System.out.println("post_id        title           image          exp_date         reg_date");

		System.out.println("-----------------------------------------------------------------------");

		while(iter.hasNext()) {

			FoodDTO food = iter.next();

			System.out.println(food.getTitle()+food.getFoodType()+food.getContent()+food.getImage()+food.getPostId());

		}    
		int blue_count = statisDao.countBlueByUserId((long)6);
		System.out.println("RedFood : " + blue_count);
		//
		//        // newMgr의 필드 값 출력 
		//
		//        System.out.printf("%d %s %s %s %.2f %.2f %d\n", 
		//
		//                newMgr.getEmpno(), newMgr.getEname(), newMgr.getJob(),
		//
		//                newMgr.getHiredate(), newMgr.getSal(), newMgr.getComm(), newMgr.getDeptNo());
		//
		// 
		
		String most = statisDao.findMostFoodType((long)6);
		System.out.println("MostFood : " + most);

		scanner.close();
		
		
>>>>>>> 4a60ce7093d43bd8f5123fc8fcb4c11c7c1e65bd
	}

}
