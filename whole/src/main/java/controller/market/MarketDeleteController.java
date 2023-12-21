package controller.market;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.entity.ItemEntity;
import model.service.MarketManager;

public class MarketDeleteController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        MarketManager marketMan = MarketManager.getInstance();
        String deleteMarket = request.getParameter("myMarketId");
        
        marketMan.removeFood(Long.parseLong(deleteMarket));
                
        return "redirect:/market";        
    }
}
