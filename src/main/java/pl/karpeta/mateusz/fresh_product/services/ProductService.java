package pl.karpeta.mateusz.fresh_product.services;

import org.springframework.stereotype.Service;
import pl.karpeta.mateusz.fresh_product.model.Brand;
import pl.karpeta.mateusz.fresh_product.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    void deleteById(Long Id) throws IllegalAccessException;

    Product getProductById(Long Id);

    List<Product> findAllProducts();

    List<Product> findExpiredProduct();

    // Product editProduct (Product product);

    /*List<Product> findAllByName (String Name);*/
}
