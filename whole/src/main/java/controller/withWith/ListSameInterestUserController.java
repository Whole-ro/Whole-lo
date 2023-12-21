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

public class ListSameInterestUserController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		long userId = Long.parseLong(UserSessionUtils.getLoginUserId(session));
		
		UserManager userMan = UserManager.getInstance();
		WithwithManager withWithMan = WithwithManager.getInstance();
		
		String interest = userMan.findInterestById(userId);
		List<UserEntity> userList = withWithMan.findUserByInterest(interest, userId);
		
		request.setAttribute("userList", userList);
	
		return "/withWith/withWith.jsp";
	}
}
