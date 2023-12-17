package controller.food;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.entity.ItemEntity;
import model.service.MarketManager;

public class FoodUpdateController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
         
//        MarketManager marketMan = MarketManager.getInstance();
//        List<ItemEntity> marketList = marketMan.viewMarketList();
//        
//        // commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
//        request.setAttribute("marketList", marketList);             
        return "/market/market_view_postlist.jsp";        
    }
    
}
