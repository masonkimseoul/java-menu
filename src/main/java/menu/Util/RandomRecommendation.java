package menu.Util;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import menu.Domain.Menu;

public class RandomRecommendation {
    private static String recommendCategory() {
        return Menu.fromCategoryNumber(Randoms.pickNumberInRange(1, 5));
    }

    private static String recommendMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
