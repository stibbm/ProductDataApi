package product.data.api.dao.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.data.api.dao.ProductDAO;
import product.data.api.model.Product;
import product.data.api.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO {
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductDAOImpl(ProductRepository productRepository) {
		this.productRepository = Validate.notNull(productRepository);
	}

	@Override
	public Product createProduct(String productName, String productDescription) {
		Validate.notNull(productName, "productName cannot be null");
		Validate.notNull(productDescription, "productDescription cannot be null");
		Product productWithoutId = Product.builder()
				.productName(productName)
				.productDescription(productDescription)
				.build();
		Product savedProduct = this.productRepository.save(productWithoutId);
		return savedProduct;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		Validate.notNull(productName, "productName cannot be null");
		List<Product> productsList = this.productRepository.findProductsByProductName(productName);
		return productsList;
	}

	@Override
	public Product getProductById(Long productId) {
		Validate.notNull(productId, "productId cannot be null");
		Product product = this.productRepository.findProductByProductId(productId);
		return product;
	}

	@Override
	public Product deleteProductById(Long productId) {
		Validate.notNull(productId, "productId cannot be null");
		Product product = this.productRepository.deleteProductByProductId(productId);
		return product;
	}

}
