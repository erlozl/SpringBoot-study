package shop.mtcoding.mallex01.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Table(name = "mall_tb")
@Entity
public class Mall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createAt;

    @ManyToOne
    private Seller seller;

}
