package pl.karpeta.mateusz.fresh_product.model.loss;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "loss_on")
@Builder
@Table(name = "loss_on")
@NoArgsConstructor
@AllArgsConstructor

public class LossOnExpiryDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal lossOnExpiryDate;

}
