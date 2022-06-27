package product.data.api.manager.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.data.api.dao.ProductDAO;
import product.data.api.manager.ProductManager;
import product.data.api.model.Product;

@Service
public class ProductManagerImpl implements ProductManager {

	private ProductDAO productDAO;
	
	@Autowired
	public ProductManagerImpl(ProductDAO productDAO) {
		this.productDAO = Validate.notNull(productDAO);
	}
	
	@Override
	public Product createProduct(String productName, String productDescription) {
		Validate.notNull(productName, "productName cannot be null");
		Validate.notNull(productDescription, "productDescription cannot be null");
		Product product = this.productDAO.createProduct(productName, productDescription);
		return product;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		Validate.notNull(productName, "productName cannot be null");
		List<Product> productsList = this.productDAO.getProductsByName(productName);
		return productsList;
	}

	@Override
	public Product getProductById(Long productId) {
		Validate.notNull(productId, "productId cannot be null");
		Product product = this.productDAO.getProductById(productId);
		return product;
	}

	@Override
	public Product deleteProductById(Long productId) {
		Validate.notNull(productId, "productId cannot be null");
		Product product = this.productDAO.deleteProductById(productId);
		return product;
	}

}
