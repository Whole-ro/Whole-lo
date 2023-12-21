package controller.user;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.entity.ItemEntity;
import model.service.MarketManager;
import model.service.UserManager;

public class UserMarketController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        long userId = Long.parseLong(UserSessionUtils.getLoginUserId(session));

        UserManager userMan = UserManager.getInstance();
        MarketManager marketMan = MarketManager.getInstance();
        
        List<ItemEntity> a = marketMan.findItemListWriter(userId);
        System.out.println(a);
        request.setAttribute("marketList", a); 
                
        return "/user/my_market.jsp";        
    }
}
