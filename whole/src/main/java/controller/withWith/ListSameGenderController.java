package controller.withWith;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.entity.UserEntity;
import model.service.UserManager;
import model.service.WithwithManager;

public class ListSameGenderController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		long userId = Long.parseLong(UserSessionUtils.getLoginUserId(session));
		
		UserManager userMan = UserManager.getInstance();
		WithwithManager withWithMan = WithwithManager.getInstance();
		
		String gender = userMan.findGenderById(userId);
		String interest = userMan.findInterestById(userId);
		
		List<UserEntity> userList = withWithMan.findSameGender(interest, userId, gender);
		
		request.setAttribute("userList", userList);
	
		return "/withWith/withWith.jsp";
	}

}
