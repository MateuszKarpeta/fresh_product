package pl.karpeta.mateusz.fresh_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.karpeta.mateusz.fresh_product.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
}
