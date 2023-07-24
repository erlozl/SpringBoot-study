package shop.mtcoding.mall.model;

//DAO , 범용적으로다가 Repository name을 사용

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;

@Repository // 컴포넌트 스캔 (즉, new 된다는 것 ( 메모리에 뜸 ))
//DAO(Data Access Object) 클래스를 나타내는 데 사용
public class ProductRepository {

    @Autowired // 스프링이 만들어놓은 걸 가지고 옴
//    IoC 컨테이너에서 타입을 찾아서 주입해줌 DI
    private EntityManager em;
//      EntityManager 데이터베이스의 접근 가능
//      커넥션풀링 기술,커넥션객체 관리하고 있음

    @Transactional
//    트랙잭션 기능
    public void save(String name, int price, int qty) {
//      쿼리 = 프로토콜이 적용된 버퍼
        Query query = em.createNativeQuery("insert into product_tb(name,price,qty) " +
                "values (:name, :price, :qty)");
        query.setParameter("name",name);
        query.setParameter("price",price);
        query.setParameter("qty",qty);
        query.executeUpdate();
    }

    @Transactional
    public Product update(Product product) {
        // 업데이트 쿼리문 작성
        Query query = em.createNativeQuery("UPDATE product_tb SET name = :name, price = :price, qty = :qty WHERE id = :id");
//        uery.setParameter() 메서드로 쿼리에 값을 바인딩하는 순서는 쿼리문에서 사용된 파라미터의 순서와 일치해야 함
        query.setParameter("name", product.getName());
        query.setParameter("price", product.getPrice());
        query.setParameter("qty", product.getQty());
        query.setParameter("id", product.getId());
        query.executeUpdate();
        return null;
    }

    public List<Product> findAll() {
        Query query = em.createNativeQuery("select * from product_tb", Product.class);
        List<Product> productList = query.getResultList();
        return productList;
    }

    public Product findById(int id) {
        Query query = em.createNativeQuery("select * from product_tb where id = :id", Product.class);
//        Product.class가 매핑해주는 클래스
        query.setParameter("id",id);
        Product product = (Product)query.getSingleResult();
        return product;
    }

    // insert, update, delete
    @Transactional // spring 트랜잭션 ( import 주의 ! )
    public void deleteById(int id) {
        Query query = em.createNativeQuery("delete from product_tb where id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

//    public Product findById2(int id) {
//        Query query = em.createNativeQuery("select * from product_tb where id = :id");
////        Product.class가 매핑해주는 클래스
////
////         row 1건
////         1, 바나나, 1000, 50
//        query.setParameter("id",id);
//         Object[] object = (Object[]) query.getSingleResult();
//         int id2 = (int)object[0];
//         String name2 = (String)object[1];
//         int price2 = (int)object[2];
//         int qty2 = (int)object[3];
//
//         Product product = new Product();
//         product.setId(id2);
//         product.setName(name2);
//         product.setPrice(price2);
//         product.setQty(qty2);
//
//        return null;
//    }
}
