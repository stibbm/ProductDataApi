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
import product.data.api.response.DeleteProductByIdResponse;

@RestController
public class DeleteProductByIdActivity {
	
	private ProductManager productManager;
	
	@Autowired
	public DeleteProductByIdActivity(ProductManager productManager) {
		this.productManager = Validate.notNull(productManager);
	}
	
	@GetMapping("/deleteProductById")
	public ResponseEntity<DeleteProductByIdResponse> deleteProductById(
			@RequestParam Long productId
	) {
		Validate.notNull(productId, "productId cannot be null");
		Product product = this.productManager.deleteProductById(productId);
		DeleteProductByIdResponse deleteProductByIdResponse = DeleteProductByIdResponse
				.builder().deletedProduct(product).build();
		ResponseEntity<DeleteProductByIdResponse> responseEntityDeleteProductByIdResponse = 
				new ResponseEntity<>(deleteProductByIdResponse, HttpStatus.OK);
		return responseEntityDeleteProductByIdResponse;
	}
	
}
