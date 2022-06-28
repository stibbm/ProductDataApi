package product.data.api.activity;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import product.data.api.manager.ProductManager;
import product.data.api.model.Product;
import product.data.api.response.GetProductsByNameResponse;

@RestController
public class GetProductsByNameActivity {

	private ProductManager productManager;
	
	@Autowired
	public GetProductsByNameActivity(ProductManager productManager) {
		this.productManager = Validate.notNull(productManager);
	}

	@GetMapping("/getProductByName")
	public ResponseEntity<GetProductsByNameResponse> getProductsByName(
			@RequestParam String productName
	) {
		Validate.notNull(productName, "productName cannot be null");
		List<Product> productsList = productManager.getProductsByName(productName);
		GetProductsByNameResponse getProductsByNameResponse = GetProductsByNameResponse.builder()
				.productsList(productsList)
				.build();
		ResponseEntity<GetProductsByNameResponse> responseEntityGetProductsByNameResponse = 
				new ResponseEntity<>(getProductsByNameResponse, HttpStatus.OK);
		return responseEntityGetProductsByNameResponse;
	}
	
}
