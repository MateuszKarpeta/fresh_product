package pl.karpeta.mateusz.fresh_product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.karpeta.mateusz.fresh_product.model.Product;
import pl.karpeta.mateusz.fresh_product.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addNewProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product, Long Id) {

    }

    @Override
    public void deleteById(Long Id) {

    }


    @Override
    public List<Product> findAllProducts() {
        return null;
    }

    @Override
    public List<Product> findExpiredProduct(LocalDate expiryDate) {
        return null;
    }
}


