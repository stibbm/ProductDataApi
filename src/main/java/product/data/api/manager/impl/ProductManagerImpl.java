package product.data.api.manager.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;

import product.data.api.dao.ProductDAO;
import product.data.api.manager.ProductManager;
import product.data.api.model.Product;

public class ProductManagerImpl implements ProductManager {

	private ProductDAO productDAO;
	
	@Autowired
	public ProductManagerImpl(ProductDAO productDAO) {
		this.productDAO = Validate.notNull(productDAO);
	}
	
	@Override
	public Product createProduct(String productName, String productDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product deleteProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
