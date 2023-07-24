package shop.mtcoding.mall.model;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

//판매자가 상품을 등록해야 하므로
//판매자 Repository도 필요함
@Repository
public class SellerRepository {

    @Autowired
    private EntityManager em;

    public String save(String name, String email) {
        Seller seller = new Seller();
        seller.setName(name);
        seller.setEmail(email);

        // 등록한 판매자의 name 값을 바로 사용
        String savedName = seller.getName();
        return savedName;
        // 이제 savedName 값을 원하는 곳에 사용하면 됨 (예: View에 전달)
    }

    public Seller findById(int id) {
        Query query = em.createNativeQuery("select * from seller_tb where id = :id", Seller.class);
//        Product.class가 매핑해주는 클래스
        query.setParameter("id",id);
        Seller seller = (Seller) query.getSingleResult();
        return seller;
    }

    public Seller findByName(String name) {
        Query query = em.createNativeQuery("select * from seller_tb where name = :name", Seller.class);
//        Product.class가 매핑해주는 클래스
        query.setParameter("name",name);
        Seller seller = (Seller) query.getSingleResult();
        return seller;
    }

    @Transactional
    public Seller update(Seller seller) {
        // 업데이트 쿼리문 작성
        Query query = em.createNativeQuery("UPDATE seller_tb SET name = :name, email = :email WHERE id = :id");
//        uery.setParameter() 메서드로 쿼리에 값을 바인딩하는 순서는 쿼리문에서 사용된 파라미터의 순서와 일치해야 함
        query.setParameter("name", seller.getName());
        query.setParameter("email", seller.getEmail());
        query.executeUpdate();
        return null;
    }
}
