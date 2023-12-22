package controller.food;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.dto.FoodDTO;
import model.entity.ItemEntity;
import model.enums.IsHealthy;
import model.service.FoodManager;
import model.service.MarketManager;
import util.FoodTypeUtil;

public class FoodUpdateController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
               
      request.setCharacterEncoding("UTF-8");
      Long postId = Long.parseLong(request.getParameter("myPostId"));
      FoodManager foodMan = FoodManager.getInstance();

      if (request.getMethod().equals("GET")) {    
       
         FoodDTO food = foodMan.findFood(postId);
         
         System.out.println(food);

         request.setAttribute("foodList", food);
         return "/myRefg/updateForm.jsp";     
  }    
      
//  // POST request (커뮤니티 정보가 parameter로 전송됨)
      HttpSession session = request.getSession();

      
      IsHealthy isHealtyh = FoodTypeUtil.getFoodColor(request.getParameter("foodType"));

      FoodDTO updateFood = new FoodDTO(
              request.getParameter("title"), 
              request.getParameter("content"),
              request.getParameter("image"),
              Long.parseLong(UserSessionUtils.getLoginUserId(session)),
              request.getParameter("foodType"),
              LocalDate.parse(request.getParameter("expDate")), 
              isHealtyh
      );
      updateFood.setPostId(Long.parseLong(request.getParameter("myPostId")));
      
      foodMan.updateFood(updateFood);

      return "redirect:/myRefg/list";            
    }
    
}
