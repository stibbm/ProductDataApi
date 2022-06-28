# Product Data Api

## Product Fields
```
Long productId
String productName
String productDescription
```

# Product Endpoints

## /createProduct
Url Params:
``` 
String productName
String productDescription
```
example: http://{ip}:{port}/createProduct?productName=product1&productDescription=This%20is%20a%20product%20description

**As shown above, the urlParams must be urlEncoded**

## /getProductById
Url Params:
```
Long productId
```
example: http://{ip}:{port}/getProductById?productId=1

## /getProductsByName
Url Params:
```
String productName
```

example: http://{ip}:{port}/getProductsByName?productName=productName1

## /deleteProductById
Url Params:
```
Long productId
```

example: http://{ip}:{port}/deleteProductById?productId=1




# How to build
chmod +x gradlew
./gradlew build

# How to clean and rerun tests / rebuild
./gradlew clean
+
./gradlew tests
or
./gradlew build