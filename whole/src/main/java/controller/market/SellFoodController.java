package controller.market;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.FoodDTO;
import model.service.FoodManager;
import model.service.MarketManager;

public class SellFoodController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Long postId = Long.parseLong(request.getParameter("postId"));
        FoodDTO sellFood = null;
        

        try {
            FoodManager foodMan = FoodManager.getInstance();
            sellFood = foodMan.findFood(postId);
            System.out.println(sellFood.toString());
            
            request.setAttribute("food", sellFood);
            
            return "/market/market_post_form.jsp";
        }catch (Exception e) {     // 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("sellFood", sellFood);
            return "/myRefg/myRefgList.jsp";
        }
       
        
        
        
       
    }
}
