package product.data.api.activity;

import product.data.api.model.Product;

public class TestCreateProductActivity {

    private static final Long TEST_PRODUCT_ID = 1L;

    private static final String TEST_PRODUCT_NAME = "testProductName";

    private static final String TEST_PRODUCT_DESCRIPTION = "testProductionDescription";

    private static final Product TEST_PRODUCT = Product.builder()
            .productId(TEST_PRODUCT_ID)
            .productName(TEST_PRODUCT_NAME)
            .productDescription(TEST_PRODUCT_DESCRIPTION)
            .build();

    

}
