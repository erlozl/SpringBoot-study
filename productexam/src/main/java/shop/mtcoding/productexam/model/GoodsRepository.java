package shop.mtcoding.productexam.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodsRepository {

    @Autowired
    private EntityManager em;


    @Transactional
    public void save (String name, int price, int qty) {
        Query query = em.createNativeQuery("insert into product_tb (name,price,qty) values (:name,:price,:qty)");
        query.setParameter("name", name);
        query.setParameter("price", price);
        query.setParameter("qty",qty);
        query.executeUpdate();
    }

    public List<Goods> findAll() {
        Query query = em.createNativeQuery("select * from product_tb", Goods.class);
        List<Goods> goodslist = query.getResultList();
        return goodslist;
    }

    public Goods findById(Integer id) {
        Query query = em.createNativeQuery("select * from product_tb where id=:id", Goods.class);
        query.setParameter("id",id);
        Goods goods = (Goods)query.getSingleResult();
//        Query 인터페이스의 getSingleResult() 메서드는 단일 결과를 반환하는데,
//        반환된 결과는 Object 타입따라서 실제로 어떤 타입인지를 컴파일러가 알지 못하기에 캐스팅 맞추기
//        여기서는 단일 캐스팅
        return goods;
    }

    @Transactional
    public Goods update(Goods goods) {
        Query query = em.createNativeQuery("UPDATE product_tb SET name = :name, price = :price, qty = :qty WHERE id = :id");
        query.setParameter("name",goods.getName());
        query.setParameter("price",goods.getPrice());
        query.setParameter("qty",goods.getQty());
        query.setParameter("id",goods.getId());
        query.executeUpdate();

        return null;
    }

}
