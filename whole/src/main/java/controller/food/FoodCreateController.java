package controller.food;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.Controller;
import model.dto.FoodDTO;
import model.enums.IsHealthy;
import model.service.FoodManager;

public class FoodCreateController implements Controller {
    
  private static final Logger log = LoggerFactory.getLogger(FoodCreateController.class);

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
   
//      this.title = title;
//      this.content = content;
//      this.image = image;
//      this.writerId = writerId;
//      this.foodType = foodType;
//      this.expDate = expDate;
//      this.isHealthy = isHealthy; 
//  }
      FoodDTO newFood = new FoodDTO(
              request.getParameter("title"), 
              request.getParameter("content"),
              request.getParameter("image"),
              Long.parseLong(request.getParameter("writerId")), 
              request.getParameter("foodType"), 
              LocalDate.parse(request.getParameter("expDate")), 
              Enum.valueOf(IsHealthy.class, request.getParameter("isHealthy"))
              );
      
    try {
        
        FoodManager foodMan = FoodManager.getInstance();
        foodMan.createFood(newFood);
        
        log.debug("Post new Food : {}", newFood);
        return "redirect:/myRefg/list";  // 성공 시 커뮤니티 리스트 화면으로 redirect
        
    } catch (Exception e) {     // 예외 발생 시 입력 form으로 forwarding
          request.setAttribute("creationFailed", true);
        request.setAttribute("exception", e);
        request.setAttribute("myRefg", newFood);
        return "/myRefg/postForm.jsp";
    }
  }
}
