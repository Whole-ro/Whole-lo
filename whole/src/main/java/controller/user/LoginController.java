package controller.user;
//
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//
import controller.Controller;
import model.service.UserManager;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
		
		try {
			// 모델에 로그인 처리를 위임

			UserManager manager = UserManager.getInstance();			
			manager.login(email, password);
			System.out.println("안녕하세요");
			// 세션에 사용자 이이디 저장
			HttpSession session = request.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, email);
            System.out.println(UserSessionUtils.getLoginUserId(session));
            
            System.out.println("안녕하세요");
            return "redirect:/market";	//사용자 목록으로...		
		} catch (Exception e) {
//			/* UserNotFoundException이나 PasswordMismatchException 발생 시
//			 * 다시 login form을 사용자에게 전송하고 오류 메세지도 출력
//			 */
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
			System.out.println("로그인 실패: " + e.getMessage());
            return "/user/loginForm.jsp";			
		}	
    }
}
