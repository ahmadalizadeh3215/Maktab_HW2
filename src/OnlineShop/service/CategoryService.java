package OnlineShop.service;

import OnlineShop.model.Category;
import OnlineShop.util.FakeDB;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final FakeDB fakeDB;

    public CategoryService(FakeDB fakeDB) {
        this.fakeDB = fakeDB;
    }
    public List<Category> getParentCategory() {
        List<Category> parentCategories = new ArrayList<>();
        for (Category s : fakeDB.getCategoryList()) {
            if(s.getParentCategory() == null){
                parentCategories.add(s);
            }
        }
        return parentCategories;
    }

    public List<Category> getSubCategory(Category category){
        List<Category> subCategories = new ArrayList<>();
        for (Category search : fakeDB.getCategoryList()) {
            if( search.getParentCategory() != null && category.getName().equals( search.getParentCategory().getName()) ) {
                subCategories.add(search);
            }
        }
        return subCategories;
    }
}
