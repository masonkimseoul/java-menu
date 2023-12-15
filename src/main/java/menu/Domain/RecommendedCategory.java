package menu.Domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendedCategory {
    private final List<String> recommendedCategory;

    public RecommendedCategory() {
        this.recommendedCategory = new ArrayList<>();
    }

    public void addRecommendedCategory(String category) {
        this.recommendedCategory.add(category);
    }

    public List<String> getRecommendedCategory() {
        return this.recommendedCategory;
    }

    public int countCategory(String name) {
        int count = 0;
        for(String category : recommendedCategory) {
            if (category.equals(name)) {
                count += 1;
            }
        }

        return count;
    }
}
