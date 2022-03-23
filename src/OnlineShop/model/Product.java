package OnlineShop.model;

public class Product {
    private String productName;
    private String description;
    private Double unitPrice;
    private Integer quantity;
    private Category category;

    public Product() {
    }

    public Product(String productName, String description, Double unitPrice, Integer amount, Category category) {
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = amount;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
