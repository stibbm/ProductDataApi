package product.data.api.activity;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import product.data.api.manager.ProductManager;

@RestController
public class GetProductsByNameActivity {

	private ProductManager productManager;
	
	@Autowired
	public GetProductsByNameActivity(ProductManager productManager) {
		this.productManager = Validate.notNull(productManager);
	}
	
	
	
}
