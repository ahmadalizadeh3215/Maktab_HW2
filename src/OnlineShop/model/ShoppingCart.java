package OnlineShop.model;

public class ShoppingCart {
    private final Product product;
    private Double totalPrice;
    private final Product[] listOfProduct ;
    private Integer lastIndex;
    private Integer quantity;

    public ShoppingCart(){
        product = new Product();
        this.listOfProduct = new Product[5];
        lastIndex = 0;
        this.totalPrice = 0.0;
        this.quantity = 0;
    }

    public Product getProduct() {
        return product;
    }

    public void addProductQuantity(Product product) {
        this.listOfProduct[lastIndex] = product;
        lastIndex++;
    }

    public void removeProductQuantity(Integer index){
        if(this.totalPrice >= this.listOfProduct[index].getUnitPrice()) {
            this.totalPrice -= this.listOfProduct[index].getUnitPrice();
        }
        for (int i = index; i < lastIndex ; i++) {
            this.listOfProduct[i] = this.listOfProduct[i + 1];
        }
    }

    public void clearShoppingCart() {
        while (true){
            if(this.listOfProduct[0] != null) {
                removeProductQuantity(0);
            }
            else {
                this.lastIndex = 0;
                break;
            }
        }
    }

    public Product[] getListOfProduct() {
        return listOfProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice += totalPrice;
    }

    public void clearTotalPrice(){
        this.totalPrice = 0.0;
    }
}
