package product.data.api.activity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import product.data.api.manager.ProductManager;
import product.data.api.model.Product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

public class TestGetProductByIdActivity {

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

    private GetProductByIdActivity getProductByIdActivity;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProductById() {
        when(productManager.getProductById(any(Long.class)))
                .thenReturn(TEST_PRODUCT);
        Product product = getProductByIdActivity.getProductByIdUrlParams(any(Long.class)).getBody().getProduct();
        assertThat(product).isEqualTo(TEST_PRODUCT);
    }


}
