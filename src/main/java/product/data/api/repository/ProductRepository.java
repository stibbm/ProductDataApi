package product.data.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import product.data.api.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
