package pl.karpeta.mateusz.fresh_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.karpeta.mateusz.fresh_product.model.Product;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Query(value = "select expiry_date, product_name, purchase_price, quantity from product where expiry_date<=today_date order by product_name"
            , nativeQuery = true)
    List<Product> findExpiredProduct();

    List<Product> findAllByName(String Name);
}
