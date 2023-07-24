package shop.mtcoding.mall.model;

//DAO , 범용적으로다가 Repository name을 사용

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.awt.*;
import java.util.List;

@Repository // 컴포넌트 스캔 (즉, new 된다는 것 ( 메모리에 뜸 ))
//DAO(Data Access Object) 클래스를 나타내는 데 사용
public class ProductRepository {

    @Autowired // 스프링이 만들어놓은 걸 가지고 옴
//    IoC 컨테이너에서 타입을 찾아서 주입해줌 DI
    private EntityManager em;
//    오브젝팅 매핑을 entity만 해줌
//    EntityManager 데이터베이스의 접근 가능
//    커넥션풀링 기술,커넥션객체 관리하고 있음

    public Product findByIdJoinSeller(int id) {
        Query query = em.createNativeQuery("select *\n" +
                "from product_tb as pt inner join seller_tb as sr \n" +
                "on pt.seller_id = sr.id\n" +
                "where pt.id = :id",Product.class);
        query.setParameter("id",id);
        Product product = (Product) query.getSingleResult();
        return product;
    }


//    전체 품목 가져오기
    public List<Product> findJoinAll() {
        Query query = em.createNativeQuery("SELECT pt.*, sr.name AS sellerName FROM product_tb pt " +
                        "INNER JOIN seller_tb sr ON pt.seller_id = sr.id", Product.class);
//        Product.class를 붙였다는 건 엔티티어노테이션이 붙어있다는 뜻
        List<Product> joinList = query.getResultList();
        return joinList;
    }


    @Transactional
    public void saveWithFK(String name, int price, int qty, int sellerId){
        Query query = em.createNativeQuery("insert into product_tb(name, price, qty, seller_id)" +
                " values(:name, :price, :qty, :sellerId)");
        query.setParameter("name", name);
        query.setParameter("price", price);
        query.setParameter("qty", qty);
        query.setParameter("sellerId", sellerId);
        query.executeUpdate();
    }


    public ProductDTO findByIdDTO(int id) {
//        DB에 없는 거 가져오기
        Query query = em.createNativeQuery("select id, name, price, qty, '설명' as des" +
                " from product_tb where id = :id");
//        조회할거기 때문에 매핑할 클래스 적어주기 ProductDTO.class
        query.setParameter("id",id);

        JpaResultMapper mapper = new JpaResultMapper();
        ProductDTO productDTO = mapper.uniqueResult(query, ProductDTO.class);
//      이 JpaResultMapper를 사용하는 것은 엔티티를 안붙였을 때 (즉, 클래스의 모델이 없을 때 )
//      연산 작업할 때 주로 쓰임, ex) 가격 표시할 때
//      한 건이면 uniqueResult, 여러 건이면 list,
        return productDTO;
    }

    @Transactional
    public void save(String name, int price, int qty){
        Query query = em.createNativeQuery("insert into product_tb(name, price, qty) " +
                "values(:name, :price, :qty)");
        query.setParameter("name", name);
        query.setParameter("price", price);
        query.setParameter("qty", qty);
        query.executeUpdate();
//      query.executeUpdate() 메서드를 실행하는 것 자체로 데이터베이스 작업을 수행
    }

    @Transactional
    public Product update(Product product) {
        // 업데이트 쿼리문 작성
        Query query = em.createNativeQuery("UPDATE product_tb SET name = :name," +
                " price = :price, qty = :qty WHERE id = :id");
//        uery.setParameter() 메서드로 쿼리에 값을 바인딩하는 순서는 쿼리문에서 사용된 파라미터의 순서와 일치해야 함
        query.setParameter("name", product.getName());
        query.setParameter("price", product.getPrice());
        query.setParameter("qty", product.getQty());
        query.setParameter("id", product.getId());
        query.executeUpdate();

//        Product productUpdate = query.executeUpdate(); // 컴파일 오류
//        query.executeUpdate()는 int 타입의 값을 반환하지만,
//        변수 productUpdate는 Product 타입으로 선언되어 있기 때문에 컴파일 오류

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
//        클래스 메타데이터를 사용하면 클래스의 구조를 분석하거나,
//        클래스의 인스턴스를 생성하거나, 리플렉션(Reflection)을 통해 클래스를 동적으로 조작하는 등의 작업

        query.setParameter("id",id);
        Product product = (Product)query.getSingleResult();
//        Query 인터페이스의 getSingleResult() 메서드는 단일 결과를 반환하는데,
//        반환된 결과는 Object 타입따라서 실제로 어떤 타입인지를 컴파일러가 알지 못하기에 캐스팅 맞추기
//        여기서는 단일 캐스팅
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
