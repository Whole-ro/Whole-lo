package util;

import model.enums.IsHealthy;

public final class FoodTypeUtil {
     
    static public final String[] FOOD_TYPE_ARRAY = {
            "간편식", "밥", "요리", "반찬", "분식", "과일", "채소", "샐러드", 
            "육류", "수산", "계란", "과자", "초콜릿", "아이스크림",
            "소스", "장류", "국", "음료", "커피" , "생수", "빵", "떡", "잼", "우유", "유제품", 
            "기타"
   };

  //파란색 음식 라스트
   static public final String[] greenFood = {"두부","도라지", "김치볶음", "호박", "아보카도", 
    										  "노른자", "브로콜리", "요거트","닭가슴살","채소","샐러드"};

   //빨간색 음식 라스트
   static public final String[] redFood = {"햄버거", "피자", "감자칩", "사이다", "초콜릿",
	        "라면", "치킨", "케이크", "과자", "소시지", "인스턴트 음식"};

   static public final IsHealthy getFoodColor(String foodType) {
        String[] red = {"간편식", "분식", "과자", "초콜릿", "아이스크림", "소스", "커피",
                "빵", "떡", "잼"};
        for (String s : red) {
            if (foodType.equals(s)) {
                return IsHealthy.RED;
            }
        }
        return IsHealthy.BLUE;
    }

}
