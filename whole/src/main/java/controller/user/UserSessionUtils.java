package controller.user;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "email";
    public static final String USER_SESSION_KEY_ID = "id";

    /* 현재 로그인한 사용자의 ID를 구함 */
    public static String getLoginUserEmail(HttpSession session) {
        String email = (String)session.getAttribute(USER_SESSION_KEY);
        System.out.println(email);
        return email;
    }
    
    public static String getLoginUserId(HttpSession session) {
        String id = (String)session.getAttribute(USER_SESSION_KEY_ID);
        System.out.println(id);
        return id;
    }

    /* 로그인한 상태인지를 검사 */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginUserEmail(session) != null) {
            return true;
        }
        return false;
    }

    /* 현재 로그인한 사용자의 ID가 userId인지 검사 */
    public static boolean isLoginUser(String email, HttpSession session) {
        String loginUser = getLoginUserEmail(session);
        if (loginUser == null) {
            return false;
        }
        return loginUser.equals(email);
    }
}
