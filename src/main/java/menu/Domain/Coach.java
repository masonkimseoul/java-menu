package menu.Domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> menusForAvoid;
    private final RecommendedMenu recommendedMenu;

    public Coach(String name, List<String> menusHate) {
        this.name = name;
        this.menusForAvoid = new ArrayList<>();
        this.recommendedMenu = new RecommendedMenu();
        menusForAvoid.addAll(menusHate);
    }

    public String getName() {
        return this.name;
    }

    public boolean isMenusForAvoid(String menuName) {
        return this.menusForAvoid.contains(menuName);
    }

    public void addRecommendedMenu(String menu) {
        this.recommendedMenu.addRecommendedMenu(menu);
    }

    public List<String> getRecommendedMenu() {
        return this.recommendedMenu.getRecommendedMenu();
    }

    public boolean isAlreadyRecommended(String menu) {
        return this.recommendedMenu.isAlreadyRecommended(menu);
    }
}
