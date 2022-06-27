package product.data.api.activity;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import product.data.api.manager.ProductManager;

@RestController
public class DeleteProductByIdActivity {
	
	private ProductManager productManager;
	
	@Autowired
	public DeleteProductByIdActivity(ProductManager productManager) {
		this.productManager = Validate.notNull(productManager);
	}
	
	@GetMapping("/deleteProductByIdUrlParams")
	public ResponseEntity<DeleteProductByIdResponse> deleteProductByIdUrlParams() {
		return null;
	}
	
}
