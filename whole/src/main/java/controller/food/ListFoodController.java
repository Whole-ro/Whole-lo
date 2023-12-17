package controller.food;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.FoodDTO;
import model.entity.ItemEntity;
import model.service.FoodManager;
import model.service.MarketManager;

public class ListFoodController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        FoodManager foodMan = FoodManager.getInstance();
        List<FoodDTO> foodList = foodMan.findFoodList();
        
        // commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
        request.setAttribute("foodList", foodList);             
        return "/myRefg/myRefgList.jsp";        
    }
}
