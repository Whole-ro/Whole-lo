package controller.food;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.entity.ItemEntity;
import model.service.FoodManager;
import model.service.MarketManager;

public class FoodUpdateController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
               
      if (request.getMethod().equals("GET")) {    
          FoodManager foodMan = FoodManager.getInstance();
       
//      Community comm = manager.findCommunity(commId); // 수정하려는 커뮤니티 정보 검색
//      request.setAttribute("community", comm);            
//      
//      List<User> members = manager.findCommunityMembers(commId); // 커뮤니티 회원 리스트 검색
//      request.setAttribute("members", members);       
//      return "/community/updateForm.jsp";   // 검색한 정보를 update form으로 전송     
  }   
//  
//  // POST request (커뮤니티 정보가 parameter로 전송됨)
//  Community comm = new Community(
//      commId,
//      request.getParameter("name"),
//      request.getParameter("desc"),
//      null, request.getParameter("chairId"), null);
//
//  log.debug("Update Community : {}", comm);
//
//  UserManager manager = UserManager.getInstance();
//  manager.updateCommunity(comm);      
        
//        MarketManager marketMan = MarketManager.getInstance();
//        List<ItemEntity> marketList = marketMan.viewMarketList();
//        
//        // commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
//        request.setAttribute("marketList", marketList);  
        
      return "redirect:/food/list";            
    }
    
}
