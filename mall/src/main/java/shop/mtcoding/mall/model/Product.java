package shop.mtcoding.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "product_tb")
@Entity
//테이블 만들어내는 어노테이션
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    auto_increment 생성하게 해주는 어노테이션
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
}
