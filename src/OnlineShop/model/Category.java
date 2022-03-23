package OnlineShop.model;

public class Category {
    private String name;
    private Category parentCategory;
    private Integer categoryId;

    public Category() {
    }

    public Category(String name, Category parentCategory, Integer categoryId) {
        this.name = name;
        this.parentCategory = parentCategory;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }
}
