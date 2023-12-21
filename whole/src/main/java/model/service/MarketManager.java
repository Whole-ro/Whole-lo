package model.service;
//
import java.sql.SQLException;
import java.util.List;
//


import model.dao.MarketDAO;
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
	
	public List<ItemEntity> viewFoodItemList() throws SQLException {
		return marketDAO.findFoodItemList();
	}


	//		컨트롤러에서 매니저를 호출하고 매니저에서 dao를 호출함

	//	public int create(UserEntity user) throws SQLException, ExistingUserException {
	//		if (userDAO.existingUser(user.getEmail()) == true) {
	//			throw new ExistingUserException(user.getEmail() + "는 존재하는 아이디입니다.");
	//		}
	//		return userDAO.create(user);
	//	}

	//	public int update(UserEntity user) throws SQLException, UserNotFoundException, ExistingUserException {
	//		int oldCommId = findUser(user.getUserId()).getCommId();
	//		if (userDAO.existingUser(user.getEmail()) == false) { 	
	//			Community comm = commDAO.findCommunity(oldCommId);  // 기존 소속 커뮤니티
	//			if (comm != null && user.getUserId().equals(comm.getChairId())) {
	//				// 사용자가 기존 소속 커뮤니티의 회장인 경우 -> 그 커뮤니티의 회장을 null로 변경 및 저장
	//				comm.setChairId(null);
	//				commDAO.updateChair(comm);
	//			}
	//		    throw new ExistingUserException(user.getEmail() + "는 존재하는 아이디입니다.");
	//		}
	//		return userDAO.update(user);
	//	}	
	//
	//	public int remove(String email) throws SQLException, UserNotFoundException {
	//		int commId = findUser(userId).getCommId();
	//		Community comm = commDAO.findCommunity(commId);  // 소속 커뮤니티
	//		if (comm != null && userId.equals(comm.getChairId())) {
	//			// 사용자가 소속 커뮤니티의 회장인 경우 -> 그 커뮤니티의 회장을 null로 변경 및 저장
	//			comm.setChairId(null);
	//			commDAO.updateChair(comm);
	//		}
	//		return userDAO.remove(email);
	//	}
	//
	//	public UserEntity findUser(String email)
	//		throws SQLException, UserNotFoundException {
	//		UserEntity user = userDAO.findUser(email);
	//		
	//		if (user == null) {
	//			throw new UserNotFoundException(email + "는 존재하지 않는 아이디입니다.");
	//		}		
	//		return user;
	//	}
	//
	//	public List<UserEntity> findUserList(String email) throws SQLException {
	//			return userDAO.findUserList(email);
	//	}
	//	

	//
	//	public boolean login(String email, String password)
	//		throws SQLException, UserNotFoundException, PasswordMismatchException {
	//		UserEntity user = findUser(email);
	////
	//		if (!user.matchPassword(password)) {
	//			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
	//		}
	//		return true;
	//	}
	//
	//	//public List<User> makeFriends(String userId) throws Exception {
	//	//	return userAanlysis.recommendFriends(userId);
	//	//}
	//	
	//	///public Community createCommunity(Community comm) throws SQLException {
	//	//	return commDAO.create(comm);		
	//	//}
	//
	//	//public int updateCommunity(Community comm) throws SQLException {
	//	//	return commDAO.update(comm);				
	//	//}
	//	
	//	//public Community findCommunity(int commId) throws SQLException {
	//		//Community comm = commDAO.findCommunity(commId); 
	//		
	//		//List<User> memberList = userDAO.findUsersInCommunity(commId);
	//		//comm.setMemberList(memberList);
	//		
	//		//int numOfMembers = userDAO.getNumberOfUsersInCommunity(commId);
	//		////comm.setNumOfMembers(numOfMembers);
	//		//return comm;
	//	//}
	//	
	//	public List<Community> findCommunityList() throws SQLException {
	//		return commDAO.findCommunityList();
	//	}
	//	
	//	//public List<User> findCommunityMembers(int commId) throws SQLException {
	//	//	return userDAO.findUsersInCommunity(commId);
	//	//}
	//
	//	public UserDAO getUserDAO() {
	//		return this.userDAO;
	//	}

}
