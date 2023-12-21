package controller.market;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.dto.FoodDTO;
import model.dto.MarketDTO;
import model.service.FoodManager;
import model.service.MarketManager;

public class UpdateMarketController implements Controller {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        System.out.println(request.getParameter("postId"));
        System.out.println("writerID : "+request.getParameter("writerId"));
    
        
        Long postId = Long.parseLong(request.getParameter("postId"));
        Long writerId = Long.parseLong(request.getParameter("writerId"));
        
        
        MarketDTO sellFood = null;
        HttpSession session = request.getSession();

       

        try {
            MarketManager marketMan = MarketManager.getInstance();
            

            if (request.getMethod().equals("GET")) {    
                
                sellFood = marketMan.findItem(postId);
                
                System.out.println(sellFood.toString());
                System.out.println(sellFood.getTitle());

                request.setAttribute("food", sellFood);

                return "/market/market_post_update.jsp";
             
            }
            System.out.println("왜 안도지??");


            MarketDTO updateItem = new MarketDTO(request.getParameter("title"), request.getParameter("content"),
                    request.getParameter("image"), writerId,
                    Long.parseLong(request.getParameter("price")), request.getParameter("itemType"));
            
            System.out.println("파라미터로 받은 itemType : "+request.getParameter("itemType"));

            updateItem.setPostId(postId);
            
            MarketManager marMan = MarketManager.getInstance();
            
            int result = marMan.updateItem(updateItem);
            
            System.out.println("update result = "+result);
//                  log.debug("Post new Food : {}", newFood);
            
            return "redirect:/market"; // 성공 시 커뮤니티 리스트 화면으로 redirect
        } catch (Exception e) { // 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("sellFood", sellFood);
            return "/myRefg/myRefgList.jsp";
        }

    }
}