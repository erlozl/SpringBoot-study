package shop.mtcoding.mallex01.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class SellerRepository {

    @Autowired
    private EntityManager em;

    public void save(String name,String phone) {
        Query query = em.createNativeQuery("insert into seller_tb (name,phone) values (:name, :phone)");
        query.setParameter("name",name);
        query.setParameter("phone",phone);
        query.executeUpdate();
    }

    public Seller findById(int id) {
        Query query = em.createNativeQuery("Select * from seller_tb where id = :id");
        query.setParameter("id",id);
        Seller seller = (Seller) query.getSingleResult();
        return seller;
    }

    public Seller findByName(String name) {
        Query query = em.createNativeQuery("Select * from seller_tb where nane = :name");
        query.setParameter("name",name);
        Seller seller = (Seller) query.getSingleResult();
        return seller;
    }
}
