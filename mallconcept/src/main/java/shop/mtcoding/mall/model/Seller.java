package shop.mtcoding.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "seller_tb")
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    auto_increment 생성하게 해주는 어노테이션
    private Integer id;
    private String name;
    private String email;
}
