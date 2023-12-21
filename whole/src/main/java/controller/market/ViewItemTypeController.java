package controller.market;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.entity.ItemEntity;
import model.service.MarketManager;

public class ViewItemTypeController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MarketManager marketMan = MarketManager.getInstance();
		List<ItemEntity> marketList=null;
		
		if (request.getParameter("itemType") != null) {
			if(request.getParameter("itemType").equals("food")) {
				 marketList = marketMan.findItemListType("음식");
			}
			else if (request.getParameter("itemType").equals("appliances")) {
				 marketList = marketMan.findItemListType("가전제품");

			}
		}
		
		// commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
		request.setAttribute("marketList", marketList);				
		return "/market/market_view_postlist.jsp";        
	}

}
