package pl.karpeta.mateusz.fresh_product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.karpeta.mateusz.fresh_product.model.Product;
import pl.karpeta.mateusz.fresh_product.repository.LossOnExpiryDateRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LossServiceImpl implements LossService {

    LossOnExpiryDateRepository lossOnExpiryDateRepository;

    @Autowired
    public LossServiceImpl(LossOnExpiryDateRepository lossOnExpiryDateRepository) {
        this.lossOnExpiryDateRepository = lossOnExpiryDateRepository;
    }

    @Override
    public List<Product> listOfLossProducts() {
        return lossOnExpiryDateRepository.listOfExpiryDateProducts();
    }

    @Override
    public BigDecimal totalLossOnExpiry() {
        if (lossOnExpiryDateRepository.totalLossOnExpiryProducts().isPresent()) {
            lossOnExpiryDateRepository.totalLossOnExpiryProducts().get();
        }
            return new BigDecimal(0);
        }
    }



