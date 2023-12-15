package menu.Util;

import java.util.List;
import menu.Domain.Menu;

public class Validation {
    private static final int MIN_COACH_NAME_LEN = 2;
    private static final int MAX_COACH_NAME_LEN = 4;
    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final int MAX_AVOID_MENU_COUNT = 2;

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ERROR_MSG_HEADER = "[ERROR] ";
    private static final String NAME_LENGTH_ERROR_MSG
            = "코치의 이름은 최소 2글자, 최대 4글자입니다.";
    private static final String COACH_COUNT_ERROR_MSG
            = "코치는 최소 2명 이상, 최대 5명 이하로 입력해야 합니다.";
    private static final String AVOIDING_MENU_COUNT_ERROR_MSG
            = "못 먹는 메뉴는 최대 2개 이하로 입력해야 합니다.";
    private static final String AVOIDING_MENU_EXISTENCE_ERROR_MSG
            = "존재하지 않는 메뉴입니다.";

    public static void validateNameLength(String name) {
        if (name.length() < MIN_COACH_NAME_LEN
                || name.length() > MAX_COACH_NAME_LEN) {
            throw new IllegalArgumentException(
                    ERROR_MSG_HEADER
                            + NAME_LENGTH_ERROR_MSG
                            + LINE_SEPARATOR
            );
        }
    }

    public static void validateCoachCount(List<String> coaches) {
        if (coaches.size() < MIN_COACH_COUNT
                || coaches.size() > MAX_COACH_COUNT) {
            throw new IllegalArgumentException(
                    ERROR_MSG_HEADER
                            + COACH_COUNT_ERROR_MSG
                            + LINE_SEPARATOR
            );
        }
    }

    public static void validateAvoidingMenuCount(List<String> avoidingMenus) {
        if (avoidingMenus.size() > MAX_AVOID_MENU_COUNT) {
            throw new IllegalArgumentException(
                    ERROR_MSG_HEADER
                            + AVOIDING_MENU_COUNT_ERROR_MSG
                            + LINE_SEPARATOR
            );
        }
    }

    public static void validateAvoidingMenuExistence(String menu) {
        if (!Menu.isContainsMenu(menu)) {
            throw new IllegalArgumentException(
                    ERROR_MSG_HEADER
                            + AVOIDING_MENU_EXISTENCE_ERROR_MSG
                            +LINE_SEPARATOR
            );
        }
    }
}
