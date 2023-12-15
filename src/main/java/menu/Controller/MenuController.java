package menu.Controller;

import java.util.ArrayList;
import java.util.List;
import menu.Domain.Coach;
import menu.Domain.Menu;
import menu.Domain.RecommendedCategory;
import menu.Domain.RecommendedMenu;
import menu.Util.RandomRecommendation;
import menu.View.InputView;
import menu.View.OutputView;

public class MenuController {
    private static final List<Coach> coaches = new ArrayList<>();
    private static final RecommendedCategory recommendedCategories = new RecommendedCategory();

    public void run() {
        getCoaches();
        for (int i = 0; i < 5; i++) {
            getRecommendationForDay(coaches);
        }
        OutputView.printRecommendedResultMsg(recommendedCategories.getRecommendedCategory());
        for (Coach coach : coaches) {
            OutputView.printRecommendedMenuMsg(coach.getName(), coach.getRecommendedMenu());
        }
        OutputView.printSystemEndMsg();
    }

    public List<String> getCoachesNames() {
        List<String> coachNames;
        try {
            OutputView.printGetCoachNameMsg();
            coachNames = InputView.getCoachNames();
        } catch (IllegalArgumentException e) {
            coachNames = getCoachesNames();
        }
        return coachNames;
    }

    public List<String> getCoachesAvoidingMenus(String coach) {
        List<String> avoidingMenus;
        try {
            OutputView.printGetAvoidingMenuMsg(coach);
            avoidingMenus = InputView.getAvoidingMenus();
            return avoidingMenus;
        } catch (IllegalArgumentException e) {
            return getCoachesAvoidingMenus(coach);
        }
    }

    public void getCoaches() {
        OutputView.printSystemIntroMsg();
        List<String> names = getCoachesNames();
        for (String name : names) {
            List<String> menus = getCoachesAvoidingMenus(name);
            Coach coach = new Coach(name, menus);
            coaches.add(coach);
        }
    }

    private void selectMenu(Coach coach, List<String> menus) {
        String rcmMenu = RandomRecommendation.recommendMenu(menus);
        while (coach.isAlreadyRecommended(rcmMenu)
                || coach.isMenusForAvoid(rcmMenu)) {
            rcmMenu = RandomRecommendation.recommendMenu(menus);
        }
        coach.addRecommendedMenu(rcmMenu);
    }

    public void getRecommendationForDay(List<Coach> coaches) {
        String category = RandomRecommendation.recommendCategory();
        if (recommendedCategories.countCategory(category) < 3) {
            recommendedCategories.addRecommendedCategory(category);
        }
        List<String> matchedMenus =  Menu.fromCategoryName(category).getMenus();
        for (Coach coach : coaches) {
            selectMenu(coach, matchedMenus);
        }
    }
}
