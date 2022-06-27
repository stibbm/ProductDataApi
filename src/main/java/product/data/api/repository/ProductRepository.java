package product.data.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import product.data.api.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
	
	List<Product> findProductsByProductName(String productName);
	
	Product findProductByProductId(Long productId);
	
	Product deleteProductByProductId(Long productId);
	
}
