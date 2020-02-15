package pl.karpeta.mateusz.fresh_product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.karpeta.mateusz.fresh_product.model.Product;
import pl.karpeta.mateusz.fresh_product.repository.ProductRepository;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long Id) throws IllegalAccessException {
        Product deleteProduct = productRepository.findById(Id).orElseThrow(IllegalAccessException::new);
        productRepository.delete(deleteProduct);
    }

    @Override
    public Product getProductById(Long Id) {
        Optional<Product> productById = Optional.ofNullable(productRepository.findById(Id).orElseThrow(IllegalArgumentException::new));
        if (productById.isPresent()) {
            return productById.get();
        } else {
            throw new IllegalArgumentException("No product record exist for given id");
        }
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findExpiredProduct() {
        List<Product> expiredProductList = productRepository.findExpiredProduct();
        return expiredProductList.stream().collect(Collectors.toList());
    }

    /*@Override
    public Product editProduct(Product product) {
        if (product.getId() == null) {
            product = productRepository.save(product);

            return product;
        } else {
            Optional<Product> productEdit = productRepository.findById(product.getId());

            if (productEdit.isPresent()) {
                Product newProduct = product.get();
                        newProduct.setId(product.getId());
                newProduct.setBrandName(product.getBrandName());
                newProduct.setCategory(product.getCategory());
                newProduct.setExpiryDate(product.getExpiryDate());
                newProduct.setName(product.getName());
                newProduct.setPurchasePrice(product.getPurchasePrice());
                newProduct.setQuantity(product.getQuantity());
                newProduct.setSellingPrice(product.getSellingPrice());
                newProduct.setTodayDate(product.getTodayDate());

                newProduct = productRepository.save(newProduct);

                return newProduct;
            } else {
                product = productRepository.save(product);

                return product;
            }
        }
    }*/
}

