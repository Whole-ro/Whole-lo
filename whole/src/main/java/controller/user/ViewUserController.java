package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.UserManager;
import model.service.UserNotFoundException;
import model.entity.UserEntity;

public class ViewUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
    	HttpSession session = request.getSession();
		String email = UserSessionUtils.getLoginUserEmail(session);


    	// 로그인 여부 확인
//    	if (!UserSessionUtils.hasLogined(request.getSession())) {
//            return "redirect:/user/login/form";		// login form 요청으로 redirect
//        }
    	
		UserManager manager = UserManager.getInstance();
		
    	UserEntity user = null;
		try {
			user = manager.findUser(email);	// 사용자 정보 검색
		} catch (UserNotFoundException e) {				
	        return "redirect:/user/list";
		}	
		
		request.setAttribute("usergender", user.getGender());		// 사용자 정보 저장	
		request.setAttribute("useraddress", user.getAddress());	
		request.setAttribute("userinterest", user.getInterest());	
		request.setAttribute("userintroduction", user.getIntroduction());	
		request.setAttribute("usernickname", user.getNickname());	
		request.setAttribute("useremail", email);	
		return "/user/mypage.jsp";				// 사용자 보기 화면으로 이동
    }
}
