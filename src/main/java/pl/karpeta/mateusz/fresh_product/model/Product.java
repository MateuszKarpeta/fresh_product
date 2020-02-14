package pl.karpeta.mateusz.fresh_product.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString

@Entity(name = "product")
@Table(name = "product")

public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name may not be null")
    @Column(name = "product_name")
    @NotEmpty
    @Length(max = 100)
    private String name;

    @NotNull(message = "Price may not be null")
    @NotEmpty
    @Column(name = "purchasePrice")
    private double purchasePrice;

    @NotNull(message = "Price may not be null")
    @NotEmpty
    @Column(name = "sellingPrice")
    private double sellingPrice;

    @Column(name = "quantity")
    @NotEmpty
    private int quantity;

    //@Temporal(TemporalType.DATE)
    @Column(name = "expiry_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;

   // @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate todayDate= LocalDate.now();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brandName;

}

