package controller.food;

import java.lang.module.FindException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.FoodDTO;
import model.entity.ItemEntity;
import model.manager.PostManager;
import model.service.FoodManager;

public class ViewFoodController implements Controller{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       // TODO Auto-generated method stub]
        
       request.setCharacterEncoding("UTF-8");
       FoodDTO item = null;
       String postId = request.getParameter("postId");
       FoodManager manager = FoodManager.getInstance();
       System.out.println("viewFoodPostId:" + postId);
       
       try {
           item = manager.findFood(Long.parseLong(postId));
       } catch (FindException e) {
          //return "/foodDetailTest.jsp";
       }
       
       request.setAttribute("item", item);
       return "/myRefg/foodDetail.jsp";
    }

}
