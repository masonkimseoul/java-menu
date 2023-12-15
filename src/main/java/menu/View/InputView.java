package menu.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.Util.Validation;

public class InputView {
    private static final String SEPARATOR = ",";

    public static List<String> getCoachNames() {
        List<String> coaches = new ArrayList<>();
        String input = Console.readLine();
        try {
            String[] coachNames = input.split(SEPARATOR);
            coaches.addAll(Arrays.asList(coachNames));
            Validation.validateCoachCount(coaches);
            for (String name : coaches) {
                Validation.validateNameLength(name);
            }
        } catch (IllegalArgumentException e) {
            coaches.clear();
            System.out.print(e.getMessage());
        }
        return coaches;
    }

    public static List<String> getAvoidingMenus() {
        List<String> avoidingMenus = new ArrayList<>();
        String input = Console.readLine();
        try {
            String[] menuNames = input.split(SEPARATOR);
            avoidingMenus.addAll(Arrays.asList(menuNames));
            Validation.validateAvoidingMenuCount(avoidingMenus);
            for (String name : avoidingMenus) {
                Validation.validateAvoidingMenuExistence(name);
            }
        } catch (IllegalArgumentException e) {
            avoidingMenus.clear();
            System.out.print(e.getMessage());
        }
        return avoidingMenus;
    }
}
