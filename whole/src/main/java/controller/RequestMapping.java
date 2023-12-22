package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.withWith.ListSameGenderController;
import controller.withWith.ListSameInterestUserController;
import controller.comm.*;
import controller.food.FoodCreateController;
import controller.food.FoodDeleteController;
import controller.food.FoodUpdateController;
import controller.food.ListFoodController;
import controller.food.SearchFoodExpController;
import controller.food.SearchFoodTitleController;
import controller.food.ViewFoodController;
import controller.market.*;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    private Map<String, Controller> mappings = new HashMap<String, Controller>();

	public void initMapping() {
		// 각 uri에 대응되는 controller 객체를 생성 및 저장
		//        mappings.put("/", new ForwardController("index.jsp"));
	    mappings.put("/user/market", new UserMarketController());
	    mappings.put("/user/logout", new LogoutController());
		mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp")); //loginForm.jsp forwarding
		mappings.put("/user/login", new LoginController()); //로그인 컨트롤러 매핑
		mappings.put("/user/updatepassword/form", new ForwardController("/user/updatepw.jsp")); //updatepw.jsp forwarding
		mappings.put("/user/updatepassword", new UpdateUserController());
		//        mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
		//        mappings.put("/user/login", new LoginController());
		//        mappings.put("/user/logout", new LogoutController());
		mappings.put("/market", new ListMarketController());
		mappings.put("/market/post/detail", new ViewPostController());
		//        mappings.put("/user/list", new ListUserController());
		mappings.put("/user/view", new ViewUserController());
		mappings.put("/market/type", new ViewItemTypeController());	
		mappings.put("/market/delete", new MarketDeleteController());

		mappings.put("/market/post/create", new CreateMarketController());
        mappings.put("/market/post/food", new SellFoodController());
        mappings.put("/market/post/update", new UpdateMarketController());

        mappings.put("/market/post/form", new ForwardController("/market/market_post_form.jsp"));
		
        // 회원 가입 폼 요청과 가입 요청 처리 병합 (폼에 커뮤니티 선택 메뉴 추가를 위함)
		mappings.put("/user/register/agreeTerms", new ForwardController("/user/sign_up_1.jsp"));
		mappings.put("/user/register/registerForm", new ForwardController("/user/sign_up_2.jsp"));
		mappings.put("/user/register", new RegisterUserController());

		//        // 사용자 정보 수정 폼 요청과 수정 요청 처리 병합
		////      mappings.put("/user/update/form", new UpdateUserFormController());
		////      mappings.put("/user/update", new UpdateUserController());        
		//        mappings.put("/user/update", new UpdateUserController());
		//        
		//        mappings.put("/user/delete", new DeleteUserController());
		//        
		//        // 커뮤니티 관련 request URI 추가
		//        mappings.put("/community/list", new ListCommunityController());
		//        mappings.put("/community/view", new ViewCommunityController());
		//        mappings.put("/community/create/form", new ForwardController("/community/creationForm.jsp"));
		//        mappings.put("/community/create", new CreateCommunityController());
		//        mappings.put("/community/update", new UpdateCommunityController());

		// 나만의 냉장고
		mappings.put("/myRefg/list", new ListFoodController());
		mappings.put("/myRefg/postForm", new ForwardController("/myRefg/postForm.jsp"));
		mappings.put("/myRefg/list/detail", new ViewFoodController());
		mappings.put("/myRefg/post", new FoodCreateController());
		mappings.put("/myRefg/delete", new FoodDeleteController());

		mappings.put("/myRefg/search/title", new SearchFoodTitleController());
		mappings.put("/myRefg/post/update", new FoodUpdateController());
		mappings.put("/myRefg/search/exp", new SearchFoodExpController());


		//같이가치
		mappings.put("/withWith", new ListSameInterestUserController());
		mappings.put("/withWith/gender", new ListSameGenderController());
		logger.info("Initialized Request Mapping!");
	}

	public Controller findController(String uri) {	
		// 주어진 uri에 대응되는 controller 객체를 찾아 반환
		return mappings.get(uri);
	}
}