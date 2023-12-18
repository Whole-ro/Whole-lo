package controller.food;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.dto.FoodDTO;
import model.entity.ItemEntity;
import model.service.FoodManager;
import model.service.MarketManager;
import model.service.StatisticsManager;

public class ListFoodController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
    	long userId = Long.parseLong(UserSessionUtils.getLoginUserId(session));
    	
        FoodManager foodMan = FoodManager.getInstance();
        StatisticsManager statisticsMan = StatisticsManager.getInstance();
        
        List<FoodDTO> foodList = foodMan.findFoodListByUserId(userId);
        List<FoodDTO> redList = statisticsMan.selectRedByUserId(userId);
        List<FoodDTO> blueList = statisticsMan.selectBlueByUserId(userId);
        
        System.out.println("foodlist : " + foodList);
        System.out.println("redList : "+redList);
        // commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
        request.setAttribute("foodList", foodList);
        request.setAttribute("redList", redList);
        request.setAttribute("blueList", blueList);
        request.setAttribute("userId", userId);
        return "/myRefg/myRefgList.jsp";        
    }
}
