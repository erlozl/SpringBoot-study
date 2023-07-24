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
//    엔티티의 기본키(primary key)를 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//     auto_increment 생성하게 해주는 어노테이션
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;

    @ManyToOne
//    다대일(N:1) 관계를 매핑
//    seller를 fk로 해서 db로 만들어짐
    private Seller seller;
}
