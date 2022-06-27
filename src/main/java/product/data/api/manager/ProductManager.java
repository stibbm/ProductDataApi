package product.data.api.manager;

import java.util.List;

import product.data.api.model.Product;

public interface ProductManager {
	
	Product createProduct(String productName, String productDescription);
	
	List<Product> getProductsByName(String productName);
	
	Product getProductById(Long productId);
	
	Product deleteProductById(Long productId);

}
