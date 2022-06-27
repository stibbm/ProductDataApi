package product.data.api.activity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import product.data.api.manager.ProductManager;
import product.data.api.model.Product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TestCreateProductActivity {

    private static final Long TEST_PRODUCT_ID = 1L;

    private static final String TEST_PRODUCT_NAME = "testProductName";

    private static final String TEST_PRODUCT_DESCRIPTION = "testProductionDescription";

    private static final Product TEST_PRODUCT = Product.builder()
            .productId(TEST_PRODUCT_ID)
            .productName(TEST_PRODUCT_NAME)
            .productDescription(TEST_PRODUCT_DESCRIPTION)
            .build();

    @Mock
    private ProductManager productManager;

    private CreateProductActivity createProductActivity;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        createProductActivity = new CreateProductActivity(productManager);
    }

    @Test
    public void testCreateProduct() {
        when(productManager.createProduct(any(String.class), any(String.class)))
                .thenReturn(TEST_PRODUCT);
        Product product = createProductActivity.createProductUrlParams(TEST_PRODUCT_NAME, TEST_PRODUCT_DESCRIPTION)
                .getBody().getCreatedProduct();
        assertThat(product).isEqualTo(TEST_PRODUCT);
    }

}
