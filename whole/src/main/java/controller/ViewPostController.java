package controller;


import java.lang.module.FindException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.ItemEntity;
import model.manager.PostManager;

public class ViewPostController implements Controller{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub]
      ItemEntity item = null;
      String postId = request.getParameter("postId");
      PostManager manager = PostManager.getInstance();
      
      try {
    	  item = manager.findItem(postId);
      } catch (FindException e) {
         return "/itemDetailTest.jsp";
      }
      
      request.setAttribute("item", item);
      return "/itemDetail.jsp";
   }
}