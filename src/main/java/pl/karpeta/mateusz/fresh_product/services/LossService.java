package pl.karpeta.mateusz.fresh_product.services;
import pl.karpeta.mateusz.fresh_product.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface LossService {
    List<Product> listOfLossProducts();
   BigDecimal totalLossOnExpiry ();
}
