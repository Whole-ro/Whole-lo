package util;

import model.enums.IsHealthy;

public final class FoodTypeUtil {
     
    static public final String[] FOOD_TYPE_ARRAY = {
            "간편식", "밥", "요리", "반찬", "분식", "과일", "채소", "샐러드", 
            "육류", "수산", "계란", "과자", "초콜릿", "아이스크림",
            "소스", "장류", "국", "음료", "커피" , "생수", "빵", "떡", "잼", "우유", "유제품", 
            "기타"
   };
    
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
