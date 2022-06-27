package product.data.api.activity;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import product.data.api.manager.ProductManager;
import product.data.api.response.GetProductByIdResponse;

@RestController
public class GetProductByIdActivity {
	
	private ProductManager productManager;
	
	@Autowired
	public GetProductByIdActivity(ProductManager productManager) {
		this.productManager = Validate.notNull(productManager);
	}

	@GetMapping("/getProductByIdUrlParams")
	public ResponseEntity<GetProductByIdResponse> getProductById() {
		
	}
}
