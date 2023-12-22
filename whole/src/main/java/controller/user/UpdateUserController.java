package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.UpdateUserManager;
import model.service.UserManager;

import model.entity.UserEntity;

public class UpdateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

		long userId = Long.parseLong(UserSessionUtils.getLoginUserId(session));

    	String password = request.getParameter("password");
		System.out.println("Password: " + password);
		System.out.println("userId: " + userId);
		UpdateUserManager uMan = UpdateUserManager.getInstance();
		 uMan.updatePw(password, userId);
			
        return "redirect:/user/view";			
    }
}