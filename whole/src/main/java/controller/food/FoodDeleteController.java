package controller.food;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.User;
import model.entity.UserEntity;
import model.service.FoodManager;
import model.service.UserManager;

public class FoodDeleteController implements Controller {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)   throws Exception {
        String deleteId = request.getParameter("userId");
        String deleteFood = request.getParameter("foodId");
        //log.debug("Delete User : {}", deleteId);

        FoodManager fManager = FoodManager.getInstance();
        UserManager manager = UserManager.getInstance();        
        HttpSession session = request.getSession(); 
    
        fManager.removeFood(Long.parseLong(deleteFood));
        return "/myRefg/myRefgList.jsp";
 
    }
  
}
