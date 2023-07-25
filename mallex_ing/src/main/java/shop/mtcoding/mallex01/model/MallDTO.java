package shop.mtcoding.mallex01.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MallDTO {

    @Autowired
    private EntityManager em;

    public List<Mall> joinFindAll() {
        Query query = em.createNativeQuery("select * \n" +
                "from mall_tb as mt inner join seller_tb st\n" +
                "On mt.seller_id = st.id where mt.id = :id");
        List<Mall> mallJoinList = query.getResultList();

        return mallJoinList;
    }


}
