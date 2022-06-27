package product.data.api.dao;

import java.util.List;
import product.data.api.model.Product;

public interface ProductDAO {

  Product createProduct(String productName, String productDescription);

  List<Product> getProductByName(String productName);

  Product getProductById(Long productId);

  Product deleteProductById(Long productId);

}
