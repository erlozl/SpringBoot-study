//package shop.mtcoding.mall.model;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.Import;
//
//import java.util.List;
//
//@Import({
//        ProductRepository.class,
//        SellerRepository.class
//})
//가져와야 할 객체가 두개라면 중괄호 써서 사용하기
//
//@DataJpaTest // T -> DS -> C -> ( R -> DB )
//public class ProductRepositoryTest {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private SellerRepository sellerRepository;
//
//    @Test
//    public void findByIdJoinSeller() {
//        sellerRepository.save("코난","zhsks@nate.com");
//        productRepository.saveWithFK("체리",2000,50,1);
//
//        Product product = productRepository.findByIdJoinSeller(1);
//        System.out.println(product.getId());
//        System.out.println(product.getName());
//        System.out.println(product.getPrice());
//        System.out.println(product.getQty());
//        System.out.println("----------");
//        System.out.println(product.getSeller().getId());
//        System.out.println(product.getSeller().getName());
//        System.out.println(product.getSeller().getEmail());
//    }
//
//    @Test
//    public void findByIdDTO_test(){
//        // given ( 테스트를 하기 위해서 필요한 데이터 만들기 )
//        productRepository.save("망고", 3000, 10);
//        // when ( 테스트 진행 )
//        ProductDTO productDTO = productRepository.findByIdDTO(1);
//
//        // then ( 테스트 확인 )
//        System.out.println(productDTO.getId());
//        System.out.println(productDTO.getName());
//        System.out.println(productDTO.getPrice());
//        System.out.println(productDTO.getQty());
//        System.out.println(productDTO.getDes());
//    }
//
//    @Test
//    public void findByIdJoinSeller_test(){
//        // given ( 테스트를 하기 위해서 필요한 데이터 만들기 )
//        productRepository.save("바나나", 5000, 50);
//
//        // when ( 테스트 진행 )
//        Product product = productRepository.findById(1);
//
//        // then ( 테스트 확인 )
//        System.out.println(product.getId());
//        System.out.println(product.getName());
//        System.out.println(product.getPrice());
//        System.out.println(product.getQty());
//    }
//
//    @Test
//    public void findById_test(){
//        // given ( 테스트를 하기 위해서 필요한 데이터 만들기 )
//        productRepository.save("바나나", 5000, 50);
//
//        // when ( 테스트 진행 )
//        Product product = productRepository.findById(1);
//
//        // then ( 테스트 확인 )
//        System.out.println(product.getId());
//        System.out.println(product.getName());
//        System.out.println(product.getPrice());
//        System.out.println(product.getQty());
//    }
//
//    @Test
//    public void findByAll_test(){
//        // given ( 테스트를 하기 위해서 필요한 데이터 만들기 )
//        productRepository.save("바나나", 5000, 50);
//        productRepository.save("체리", 2000, 70);
//        productRepository.save("망고", 3000, 10);
//
//        // when ( 테스트 진행 )
//        Product product = productRepository.findById(1);
//        List<Product> productList = productRepository.findAll();
//
//        // then ( 테스트 확인 )
//        System.out.println(product.getId());
//        System.out.println(product.getName());
//
//        for (Product product1 : productList) {
//            System.out.println("==========");
//            System.out.println(product.getId());
//            System.out.println(product.getName());
//            System.out.println(product.getPrice());
//            System.out.println(product.getQty());
//        }
//    }
//
//
//}