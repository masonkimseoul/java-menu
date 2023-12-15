package menu.View;

import java.util.List;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String SYSTEM_START_MSG
            = "점심 메뉴 추천을 시작합니다.";
    private static final String GET_COACH_NAME_MSG
            = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String GET_AVOIDING_MENU_MSG
            = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RECOMMENDATION_RESULT_MSG
            = "메뉴 추천 결과입니다.";
    private static final String PRINT_DAYS_LAYOUT_MSG
            = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String PRINT_RECOMMENDED_CATEGORY
            = "[ 카테고리 | %s | %s | %s | %s | %s ]";
    private static final String PRINT_RECOMMENDED_MENU
            = "[ %s | %s | %s | %s | %s | %s ]";
    private static final String SYSTEM_END_MSG
            = "추천을 완료했습니다.";

    public static void printSystemIntroMsg() {
        System.out.print(SYSTEM_START_MSG + LINE_SEPARATOR);
    }

    public static void printGetCoachNameMsg() {
        System.out.print(LINE_SEPARATOR + GET_COACH_NAME_MSG + LINE_SEPARATOR);
    }

    public static void printGetAvoidingMenuMsg(String coach) {
        String formattedString = String.format(GET_AVOIDING_MENU_MSG, coach);
        System.out.print(LINE_SEPARATOR + formattedString + LINE_SEPARATOR);
    }

    public static void printRecommendedCategoryMsg(List<String> categories) {
        String formattedString = String.format(PRINT_RECOMMENDED_CATEGORY,
                categories.get(0),
                categories.get(1),
                categories.get(2),
                categories.get(3),
                categories.get(4));

        System.out.print(LINE_SEPARATOR + formattedString);
    }

    public static void printRecommendedMenuMsg(String coach, List<String> menus) {
        String formattedString = String.format(PRINT_RECOMMENDED_MENU,
                coach,
                menus.get(0),
                menus.get(1),
                menus.get(2),
                menus.get(3),
                menus.get(4));
        System.out.print(LINE_SEPARATOR + formattedString);
    }

    public static void printRecommendedResultMsg(List<String> categories) {
        System.out.print(LINE_SEPARATOR + RECOMMENDATION_RESULT_MSG);
        System.out.print(LINE_SEPARATOR + PRINT_DAYS_LAYOUT_MSG);
        printRecommendedCategoryMsg(categories);
    }

    public static void printSystemEndMsg() {
        for (int i = 0; i < 2; i++) {
            System.out.print(LINE_SEPARATOR);
        }
        System.out.print(SYSTEM_END_MSG + LINE_SEPARATOR);
    }
}
