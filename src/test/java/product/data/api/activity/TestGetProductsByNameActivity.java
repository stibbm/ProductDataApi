package product.data.api.activity;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import product.data.api.manager.ProductManager;
import product.data.api.activity.GetProductsByNameActivity;
import product.data.api.manager.impl.ProductManagerImpl;
import product.data.api.model.Product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

public class TestGetProductsByNameActivity {

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

    private GetProductsByNameActivity getProductsByNameActivity;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.getProductsByNameActivity = new GetProductsByNameActivity(productManagerImpl);
    }

    @Test
    public void testGetProductsByName() {
        when(productManagerImpl.getProductsByName(any(String.class)))
                .thenReturn(ImmutableList.of(TEST_PRODUCT));
        Product product = this.getProductsByNameActivity.getProductsByName(TEST_PRODUCT_NAME).getBody()
                .getProductsList().get(0);
        assertThat(product).isEqualTo(TEST_PRODUCT);
    }
}
