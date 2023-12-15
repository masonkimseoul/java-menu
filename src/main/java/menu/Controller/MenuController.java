package menu.Controller;

import java.util.ArrayList;
import java.util.List;
import menu.Domain.Coach;
import menu.Domain.RecommendedCategory;
import menu.View.InputView;
import menu.View.OutputView;

public class MenuController {
    private static final List<Coach> coaches = new ArrayList<>();
    private static final RecommendedCategory categories = new RecommendedCategory();

    public void run() {
        getCoaches();
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
        } catch (IllegalArgumentException e) {
            avoidingMenus = getCoachesAvoidingMenus(coach);
        }
        return avoidingMenus;
    }

    public void getCoaches() {
        List<String> names = getCoachesNames();
        for (String name : names) {
            List<String> menus = getCoachesAvoidingMenus(name);
            Coach coach = new Coach(name, menus);
            coaches.add(coach);
        }
    }

}
