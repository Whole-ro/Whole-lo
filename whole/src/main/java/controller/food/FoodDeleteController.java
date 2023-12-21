package controller.food;

import java.util.Enumeration;

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
        
        
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            
            // paramName과 paramValue를 사용하여 필요한 작업 수행
            System.out.println("Parameter Name: " + paramName + ", Value: " + paramValue + "<br>");
        }
        
        
        
        //String deleteId = request.getParameter("userId");
        String deleteFood = request.getParameter("myPostId");
        //log.debug("Delete User : {}", deleteId);

        FoodManager fManager = FoodManager.getInstance();
        //UserManager manager = UserManager.getInstance();        
        //HttpSession session = request.getSession(); 
        
        System.out.println("postid: " + deleteFood);
    
        int result = fManager.removeFood(Long.parseLong(deleteFood));
        
        System.out.println("와이라노...");
        System.out.println("result는 무엇일까요? "+result);


        return "redirect:/myRefg/list";
 
    }
  
}
