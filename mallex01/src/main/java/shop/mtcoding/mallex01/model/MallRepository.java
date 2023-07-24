package shop.mtcoding.mallex01.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MallRepository {

    @Autowired
    private EntityManager em;

    public List<Mall> findjoinAll() {
        Query query = em.createNativeQuery("select * \n" +
                "from mall_tb as mt inner join seller_tb st\n" +
                "On mt.seller_id = st.id;",Mall.class);
        List<Mall> joinList = query.getResultList();

        return joinList;
    }

    @Transactional
    public void saveWidthFk(String name, Integer price, Integer qty, String sellerId, LocalDate createAt) {
        Query query = em.createNativeQuery("insert into mall_tb (name,price,qty,create_at) values (:name, :price, :qty , :sellerId, :createAt)");
        query.setParameter("name", name);
        query.setParameter("price", price);
        query.setParameter("qty", qty);
        query.setParameter("sellerId", sellerId);
        query.setParameter("createAt",createAt);
        query.executeUpdate();
    }

    @Transactional
    public Mall save(Mall mall) {
        Query query = em.createNativeQuery("insert into mall_tb (name,price,qty,create_at) values (:name, :price, :qty , :createAt)");
        query.setParameter("name",mall.getName());
        query.setParameter("price",mall.getPrice());
        query.setParameter("qty",mall.getQty());
        query.setParameter("createAt",mall.getCreateAt());
        query.executeUpdate();
        return mall;
    }

    @Transactional
    public Mall update(Mall mall) {
        Query query = em.createNativeQuery("update mall_tb set name = :name, price = :price, qty = :qty , create_at = :createAt where id = :id");
        query.setParameter("name",mall.getName());
        query.setParameter("price",mall.getPrice());
        query.setParameter("qty",mall.getQty());
        query.setParameter("createAt",mall.getCreateAt());
        query.setParameter("id",mall.getId());
        query.executeUpdate();
        return mall;
    }

    public Mall findById(int id) {
        Query query = em.createNativeQuery("select * from mall_tb where id = :id",Mall.class);
        query.setParameter("id",id);
        Mall mallProduct = (Mall)query.getSingleResult();
        return mallProduct;
    }

    public List<Mall> findAll() {
        Query query = em.createNativeQuery("select * from mall_tb",Mall.class);
        List<Mall> mallList = query.getResultList();
        return mallList;
    }

    @Transactional
    public void deleteById(Integer id) {
        Query query = em.createNativeQuery("delete from mall_tb where id= :id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

}
