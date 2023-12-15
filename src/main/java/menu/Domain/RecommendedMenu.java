package menu.Domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendedMenu {
    private final List<String> recommendedMenus;

    public RecommendedMenu() {
        this.recommendedMenus = new ArrayList<>();
    }

    public void addRecommendedMenu(String menu) {
        this.recommendedMenus.add(menu);
    }

    public List<String> getRecommendedMenu() {
        return this.recommendedMenus;
    }

    public boolean isAlreadyRecommended(String menu) {
        return this.recommendedMenus.contains(menu);
    }
}
