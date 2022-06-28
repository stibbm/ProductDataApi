package product.data.api.dao;



import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.google.common.collect.ImmutableList;
import product.data.api.dao.impl.ProductDAOImpl;
import product.data.api.model.Product;
import product.data.api.repository.ProductRepository;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TestProductDAO {
	
    private static final Long TEST_PRODUCT_ID = 1L;
    private static final String TEST_PRODUCT_NAME = "testProductName";
    private static final String TEST_PRODUCT_DESCRIPTION = "testProductionDescription";
    private static final Product TEST_PRODUCT = Product.builder()
            .productId(TEST_PRODUCT_ID)
            .productName(TEST_PRODUCT_NAME)
            .productDescription(TEST_PRODUCT_DESCRIPTION)
            .build();
    
    @Mock
    private ProductRepository productRepository;
    
    private ProductDAOImpl productDAOImpl;
    
    @Before
    public void init() {
    	MockitoAnnotations.initMocks(this);
    	this.productDAOImpl = new ProductDAOImpl(productRepository);
    }
    
    @Test
    public void testCreateProduct() {
    	when(productRepository.save(any(Product.class)))
    		.thenReturn(TEST_PRODUCT);
    	Product createdProduct = productDAOImpl.createProduct(TEST_PRODUCT_NAME, TEST_PRODUCT_DESCRIPTION);
    	Assertions.assertThat(createdProduct).isEqualTo(TEST_PRODUCT);
    }
    
    @Test
    public void testGetProductById() {
    	when(productRepository.findProductByProductId(any(Long.class)))
    		.thenReturn(TEST_PRODUCT);
    	Product product = productDAOImpl.getProductById(TEST_PRODUCT_ID);
    	Assertions.assertThat(product).isEqualTo(TEST_PRODUCT);
    }
    
    @Test
    public void testGetProductsByName() {
    	when(productRepository.findProductsByProductName(TEST_PRODUCT_NAME))
    		.thenReturn(ImmutableList.of(TEST_PRODUCT));
    	Product product = productDAOImpl.getProductsByName(TEST_PRODUCT_NAME).get(0);
    	Assertions.assertThat(product).isEqualTo(TEST_PRODUCT);
    }

    @Test
    public void testDeleteProductById() {
        when(productRepository.deleteProductByProductId(any(Long.class)))
                .thenReturn(TEST_PRODUCT);
        Product deletedProduct = productDAOImpl.deleteProductById(TEST_PRODUCT_ID);
        Assertions.assertThat(deletedProduct).isEqualTo(TEST_PRODUCT);
    }
	
}
