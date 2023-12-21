package model.service;
//
import java.sql.SQLException;
import java.util.List;
//


import model.dao.MarketDAO;
import model.dto.MarketDTO;
import model.entity.ItemEntity;
//
///**
// * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
// * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
// * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
// * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
// * 별도로 둘 수 있다.
// */
public class MarketManager {
	private static MarketManager marketMan = new MarketManager();
	private MarketDAO marketDAO;
	//	private CommunityDAO commDAO;
	//	private UserAnalysis userAanlysis;
	//
	private MarketManager() {
		try {
			marketDAO = new MarketDAO();
			//			commDAO = new CommunityDAO();
			//			userAanlysis = new UserAnalysis(userDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public static MarketManager getInstance() {
		return marketMan;
	}

	// 타입 상관없이 모든 글을 보여주기
	public List<ItemEntity> viewMarketList()
			throws SQLException {
		return marketDAO.findItemListAllType();
	}
	
	public MarketDTO createItem(MarketDTO item) throws SQLException, ExistingUserException {
	    return marketDAO.createMarket(item);
	}
	public List<ItemEntity> findItemListType(String itemType)
			throws SQLException {
		return marketDAO.findItemListType(itemType);
	}
	
	
//	public List<ItemEntity> viewFoodItemList() throws SQLException {
//		return marketDAO.findFoodItemList();
//	}
//	
//	public List<ItemEntity> viewHomeAppliancesItemList() throws SQLException {
//		return marketDAO.findHomeAppliancesItemList();
//	}


}
