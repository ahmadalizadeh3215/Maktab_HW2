package OnlineShop.service;

import OnlineShop.model.Category;
import OnlineShop.model.Product;
import OnlineShop.util.FakeDB;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private  final FakeDB fakeDB;

    public ProductService(FakeDB fakeDB) {
        this.fakeDB = fakeDB;
    }
    public void addQuantityProductUpdate(Product product){
        fakeDB.saveQuantityProductUpdate(product);
    }

    public List<Product> getProduct(Category category){
        List<Product> products = new ArrayList<>();
        for (Product search : fakeDB.getProductList()) {
            if(search.getCategory() != null && search.getCategory().getName().equals(category.getName()) &&
                    search.getCategory().getCategoryId().equals(category.getCategoryId())){
                products.add(search);
            }
        }
        return products;
    }
}
