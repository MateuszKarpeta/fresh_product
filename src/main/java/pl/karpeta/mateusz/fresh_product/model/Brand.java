package pl.karpeta.mateusz.fresh_product.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "brand")

public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="brand_name")
    private String brandName;

    @OneToMany(mappedBy = "brandName")
    public List<Product> products;

}