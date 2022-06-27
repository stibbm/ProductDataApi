package product.data.api.response;

import lombok.Data;
import lombok.Builder;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import product.data.api.model.Product;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProductByIdResponse implements Serializable {
	private Product deletedProduct;
}
