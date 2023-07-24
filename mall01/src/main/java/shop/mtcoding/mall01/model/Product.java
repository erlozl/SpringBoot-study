package shop.mtcoding.mall01.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "product_tb")
@Entity
//테이블 만들어내는 어노테이션
public class Product {
//    연관관계의 주인
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    auto_increment 생성하게 해주는 어노테이션
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;


    @ManyToOne // fk
//    seller_id로 만들어짐
    private Seller seller;
//    private Integer sellerId; 도 가능
//    판매자가 있어야 등록을 할 수 있다


}
