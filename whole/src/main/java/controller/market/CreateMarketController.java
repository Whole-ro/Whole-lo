package controller.market;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.dto.FoodDTO;
import model.dto.MarketDTO;
import model.entity.ItemEntity;
import model.enums.IsHealthy;
import model.service.FoodManager;
import model.service.MarketManager;
import util.FoodTypeUtil;

public class CreateMarketController implements Controller {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        System.out.println("price: "+request.getParameter("price"));
        System.out.println("itemType: "+request.getParameter("itemType"));

        MarketDTO newItem = new MarketDTO(request.getParameter("title"), request.getParameter("content"),
                request.getParameter("image"), Long.parseLong(UserSessionUtils.getLoginUserId(session)),
                Long.parseLong(request.getParameter("price")), request.getParameter("itemType"));

        
        System.out.println(newItem.toString());
        try {

            MarketManager marMan = MarketManager.getInstance();
            marMan.createItem(newItem);

//                  log.debug("Post new Food : {}", newFood);
            return "redirect:/market"; // 성공 시 커뮤니티 리스트 화면으로 redirect

        } catch (Exception e) { // 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("myRefg", newItem);
            return "/market/post_form.jsp";
        }
    }

}
