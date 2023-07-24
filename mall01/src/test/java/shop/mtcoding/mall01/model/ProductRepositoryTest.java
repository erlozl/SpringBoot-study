package shop.mtcoding.mall01.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import({
        ProductRepository.class,
        SellerRepository.class
})
@DataJpaTest // T -> DS -> C -> ( R -> DB )

public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SellerRepository sellerRepository;

    @Test
    public void findByIdJoinSeller_test(){
        // given ( 테스트를 하기 위한 데이터 만들기 )
        sellerRepository.save("코난","email@nate.com");
        productRepository.saveWidthFk("바나나", 5000, 50,1);
        // when ( 실제 테스트 진행 )
        Product product = productRepository.findByJoinSeller(1);

        // then ( 테스트 확인 )
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQty());
        System.out.println(product.getSeller().getId());
        System.out.println(product.getSeller().getName());
        System.out.println(product.getSeller().getEmail());
    }

    @Test
    public void findByIdDTO_test() {
        productRepository.save("바나나", 5000, 50);

        ProductDTO productDTO = productRepository.findByIdDTO(1);
        System.out.println(productDTO.getId());
        System.out.println(productDTO.getName());
        System.out.println(productDTO.getPrice());
        System.out.println(productDTO.getQty());
        System.out.println(productDTO.getDes());

    }
    @Test
    public void findById_test(){
        // given ( 테스트를 하기 위한 데이터 만들기 )
        productRepository.save("바나나", 5000, 50);
        // when ( 실제 테스트 진행 )
        Product product = productRepository.findById(1);

        // then ( 테스트 확인 )
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQty());
    }



    @Test
    public void findAll_test() {
        productRepository.save("체리", 5000, 50);
        productRepository.save("복숭아", 5000, 50);
        List<Product> productList = productRepository.findAll();
        for (Product product : productList) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getQty());
        }
    }


}