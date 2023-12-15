package menu.Domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> menusForAvoid;

    public Coach(String name, List<String> menusHate) {
        this.name = name;
        this.menusForAvoid = new ArrayList<>();
        menusForAvoid.addAll(menusHate);
    }

    public String getName() {
        return this.name;
    }

    public boolean isMenusForAvoid(String menuName) {
        return this.menusForAvoid.contains(menuName);
    }
}
