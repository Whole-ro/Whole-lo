package controller.food;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.dto.FoodDTO;
import model.entity.ItemEntity;
import model.service.FoodManager;
import model.service.FoodstaticsManager;
import model.service.MarketManager;
import model.service.StatisticsManager;
import model.service.UserManager;
import util.FoodTypeUtil;

public class ListFoodController implements Controller {
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
    	long userId = Long.parseLong(UserSessionUtils.getLoginUserId(session));
    	
    	UserManager userMan = UserManager.getInstance();
        FoodManager foodMan = FoodManager.getInstance();
        StatisticsManager statisticsMan = StatisticsManager.getInstance();
        
        List<FoodDTO> foodList = foodMan.findFoodListByUserId(userId);
        List<FoodDTO> redList = statisticsMan.selectRedByUserId(userId);
        List<FoodDTO> blueList = statisticsMan.selectBlueByUserId(userId);
        String nickname = userMan.findUserNickNameById(userId);
        String mostFood = statisticsMan.findMostFoodType(userId);
        int redCnt = statisticsMan.countRedByUserId(userId);
        int blueCnt = statisticsMan.countBlueByUserId(userId);
        String light="";
        if (redCnt > blueCnt) { light="빨간색"; }
        else if (redCnt == blueCnt) { light = "노란색"; }
        else { light = "파란색"; }
        
        System.out.println("foodlist : " + foodList);
        System.out.println("redList : "+redList);
        // commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
        request.setAttribute("foodList", foodList);
        request.setAttribute("redList", redList);
        request.setAttribute("blueList", blueList);
        request.setAttribute("userId", userId);
        request.setAttribute("nickname", nickname);
        request.setAttribute("mostFood", mostFood);
        request.setAttribute("light", light);
        
        FoodstaticsManager fstaticsman = FoodstaticsManager.getInstance();
        FoodTypeUtil greenfoods = new FoodTypeUtil();
        List<String> myGreenFood = fstaticsman.viewstaticlist(userId);
        List<String> recommendgreenFood = new ArrayList<>();

        for (String food : greenfoods.greenFood) {

        	    if (!myGreenFood.contains(food)) {
        	        recommendgreenFood.add(food);
        	    }
        }
        System.out.println("myGreenFood : "+recommendgreenFood);
        request.setAttribute("recommendgreenFood", recommendgreenFood);
        
        return "/myRefg/myRefgList.jsp";  
        
        
        
        
        
    }
}
