package product.data.api.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import product.data.api.model.Product;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductResponse implements Serializable {
	private Product createdProduct;
}
