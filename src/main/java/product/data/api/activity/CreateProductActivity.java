
package product.data.api.activity;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import product.data.api.manager.ProductManager;
import product.data.api.model.Product;
import product.data.api.response.CreateProductResponse;

@RestController
public class CreateProductActivity {

	private ProductManager productManager;
	
	@Autowired
	public CreateProductActivity(ProductManager productManager) {
		this.productManager = Validate.notNull(productManager);
	}
	
	@GetMapping("/createProduct")
	public ResponseEntity<CreateProductResponse> createProductUrlParams(
			@RequestParam String productName,
			@RequestParam String productDescription
	) {
		Validate.notNull(productName, "productName cannot be null");
		Validate.notNull(productDescription, "productDescription cannot be null");
		Product product = this.productManager.createProduct(productName, productDescription);
		CreateProductResponse createProductResponse = CreateProductResponse.builder()
				.createdProduct(product)
				.build();
		ResponseEntity<CreateProductResponse> responseEntityCreateProductResponse = 
				new ResponseEntity<CreateProductResponse>(createProductResponse, HttpStatus.OK);
		return responseEntityCreateProductResponse;
	}
	
}
