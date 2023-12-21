package controller.food;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.FoodDTO;
import model.service.FoodManager;

public class SearchFoodExpController implements Controller {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String title = request.getParameter("title");
        FoodManager foodMan = FoodManager.getInstance();
        List<FoodDTO> foodList2 = foodMan.clickExpDate();
        //System.out.println("title" + title);
        System.out.println(foodList2);
        
        // commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
        request.setAttribute("foodList", foodList2);             
        return "/myRefg/myRefgList.jsp";        
    }
}
