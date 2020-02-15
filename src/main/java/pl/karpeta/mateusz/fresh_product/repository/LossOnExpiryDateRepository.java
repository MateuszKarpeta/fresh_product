package pl.karpeta.mateusz.fresh_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.karpeta.mateusz.fresh_product.model.Product;
import pl.karpeta.mateusz.fresh_product.model.loss.LossOnExpiryDate;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface LossOnExpiryDateRepository extends JpaRepository<LossOnExpiryDate,Long>{

   @Transactional
   @Query(value = "select Id, product_name, purchase_price *quantity from product where expiry_date<=today_date", nativeQuery = true)
   List<Product> listOfExpiryDateProducts();

   @Query(value="select sum(purchase_price * quantity) from product where expiry_date<=today_date", nativeQuery = true)
   Optional<BigDecimal> totalLossOnExpiryProducts();
}
