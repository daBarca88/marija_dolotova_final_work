package lv.lu.finalwork.service;

import lv.lu.finalwork.model.repository.Product;
import lv.lu.finalwork.model.repository.ProductCategory;
import lv.lu.finalwork.model.ui.ProductData;
import lv.lu.finalwork.model.ui.ProductInputData;

import java.math.BigDecimal;


// klase kas atbild par konvertesanu.ir redzama tikai Service mape - paligklase ProductService klasei
public class ProductMapper {

    public Product mapFrom(ProductInputData productInputData) {
        Product product = new Product();
        product.setName(productInputData.getName());
        product.setPrice(BigDecimal.valueOf(productInputData.getPrice()));
        product.setCategory(ProductCategory.valueOf(productInputData.getCategory()));

        if (productInputData.getDiscount() != null) {
            product.setDiscount(BigDecimal.valueOf(productInputData.getDiscount()));
        }
        if (productInputData.getDescription() != null) {
            product.setDescription(productInputData.getDescription());
        }
        return product;
    }

    ProductData mapFrom(Product product) {
        ProductData productData = new ProductData(
                product.getId().toString(),
                product.getName(),
                product.getPrice().toPlainString(),
                product.getCategory().name());  // jo attelos ENUM
        return productData;
    }
}
