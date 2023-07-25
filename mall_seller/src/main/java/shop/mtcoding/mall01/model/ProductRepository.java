package shop.mtcoding.mall01.model;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private EntityManager em;

    public Product findByJoinSeller(int id) {
        Query query = em.createNativeQuery("select * \n" +
                        "from product_tb pt inner join seller_tb st\n" +
                        "on pt.seller_id = st.id\n" +
                        "where pt.id = :id",Product.class);
        query.setParameter("id",id);
        Product product = (Product) query.getSingleResult();
        return product;
    }

//    db에 없는 것을 가지고 와보기
    public ProductDTO findByIdDTO(int id) {
        Query query = em.createNativeQuery("select id,name,price,qty, '설명' des from product_tb where id= :id");
        query.setParameter("id", id);
        JpaResultMapper mapper = new JpaResultMapper();
        ProductDTO productDTO = mapper.uniqueResult(query, ProductDTO.class);
        return productDTO;
    }

    @Transactional
    public void saveWidthFk(String name, int price, int qty, int sellerId) {
        Query query = em.createNativeQuery("insert into product_tb(name, price,qty,seller_id) " +
                "values (:name, :price, :qty, :sellerId)");
        query.setParameter("name",name);
        query.setParameter("price",price);
        query.setParameter("qty",qty);
        query.setParameter("sellerId",sellerId);
        query.executeUpdate();
    }
    @Transactional
    public void save(String name, int price, int qty) {
        Query query = em.createNativeQuery("insert into product_tb(name, price,qty) values (:name, :price, :qty)");
        query.setParameter("name",name);
        query.setParameter("price",price);
        query.setParameter("qty",qty);
        query.executeUpdate();
    }

    public List<Product> findAll() {
        Query query = em.createNativeQuery("select * from product_tb",Product.class);
        List<Product> productList = query.getResultList();
        return productList;
    }

    public Product findById(int id) {
//        컨트롤러로부터 전달받으면 됨 아이디를
        Query query = em.createNativeQuery("select * from product_tb where id = :id",Product.class);
        query.setParameter("id",id);
        Product product = (Product) query.getSingleResult();
        return product;
    }


    @Transactional
    public Product update(Product product) {
        Query query = em.createNativeQuery("update product_tb set name= :name, price= :price, qty= :qty where id= :id");
        query.setParameter("name",product.getName());
        query.setParameter("price",product.getPrice());
        query.setParameter("qty",product.getQty());
        query.setParameter("id",product.getId());
        query.executeUpdate();
        return product;
    }
    @Transactional
    public void deleteById(int id) {
        Query query = em.createNativeQuery("delete from product_tb where id = :id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

}
