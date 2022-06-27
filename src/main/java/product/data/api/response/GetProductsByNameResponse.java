package product.data.api.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import product.data.api.model.Product;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetProductsByNameResponse implements Serializable {
	private List<Product> productsList;
}
