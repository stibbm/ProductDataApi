package product.data.api.manager;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import product.data.api.dao.impl.ProductDAOImpl;
import product.data.api.manager.impl.ProductManagerImpl;
import product.data.api.model.Product;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TestProductManager {

    private static final Long TEST_PRODUCT_ID = 1L;
    private static final String TEST_PRODUCT_NAME = "testProductName";
    private static final String TEST_PRODUCT_DESCRIPTION = "testProductionDescription";
    private static final Product TEST_PRODUCT = Product.builder()
            .productId(TEST_PRODUCT_ID)
            .productName(TEST_PRODUCT_NAME)
            .productDescription(TEST_PRODUCT_DESCRIPTION)
            .build();

    @Mock
    private ProductDAOImpl productDAOImpl;

    private ProductManagerImpl productManagerImpl;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        productManagerImpl = new ProductManagerImpl(productDAOImpl);
    }

    @Test
    public void testCreateProduct() {
        when(productDAOImpl.createProduct(any(String.class), any(String.class)))
                .thenReturn(TEST_PRODUCT);
        Product createdProduct = productManagerImpl.createProduct(TEST_PRODUCT_NAME, TEST_PRODUCT_DESCRIPTION);
        Assertions.assertThat(createdProduct).isEqualTo(TEST_PRODUCT);
    }

    @Test
    public void testGetProductById() {
        when(productDAOImpl.getProductById(any(Long.class)))
                .thenReturn(TEST_PRODUCT);
        Product product = productManagerImpl.getProductById(TEST_PRODUCT_ID);
        Assertions.assertThat(product).isEqualTo(TEST_PRODUCT);
    }

    @Test
    public void testGetProductByName() {
        when(productDAOImpl.getProductsByName(TEST_PRODUCT_NAME))
            .thenReturn(ImmutableList.of(TEST_PRODUCT));
        Product product = productManagerImpl.getProductsByName(TEST_PRODUCT_NAME).get(0);
        Assertions.assertThat(product).isEqualTo(TEST_PRODUCT);
    }

    @Test
    public void testDeleteProductById() {
        when(productDAOImpl.deleteProductById(any(Long.class)))
            .thenReturn(TEST_PRODUCT);
        Product deletedProduct = productManagerImpl.deleteProductById(TEST_PRODUCT_ID);
        assertThat(deletedProduct).isEqualTo(TEST_PRODUCT);
    }


}