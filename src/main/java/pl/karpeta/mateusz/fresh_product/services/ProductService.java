package pl.karpeta.mateusz.fresh_product.services;

import pl.karpeta.mateusz.fresh_product.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {

    void addNewProduct (Product product);
    void updateProduct (Product product, Long Id);
    void deleteById (Long Id);
    List<Product> findAllProducts ();
    List<Product> findExpiredProduct (LocalDate expiryDate);
}
