package shop.mtcoding.mall01.model;

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

//    한 명의 셀러는 여러개의 상품을 가질 수 있음
//    여기서 말하는 여러 개는 행을 의미

}
