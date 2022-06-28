package product.data.api.activity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import product.data.api.manager.ProductManager;
import product.data.api.manager.impl.ProductManagerImpl;
import product.data.api.model.Product;
import product.data.api.response.GetProductByIdResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

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
    private ProductManagerImpl productManagerImpl;

    private GetProductByIdActivity getProductByIdActivity;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.getProductByIdActivity = new GetProductByIdActivity(productManagerImpl);
    }

    @Test
    public void testGetProductById() {
        when(productManagerImpl.getProductById(any(Long.class)))
                .thenReturn(TEST_PRODUCT);
        ResponseEntity<GetProductByIdResponse> responseEntityGetProductByIdResponse
                = getProductByIdActivity.getProductById(TEST_PRODUCT_ID);
        assertThat(responseEntityGetProductByIdResponse.getBody().getProduct()).isEqualTo(TEST_PRODUCT);
    }
}
