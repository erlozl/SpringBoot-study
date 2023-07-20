package shop.mtcoding.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.mall.model.Product;
import shop.mtcoding.mall.model.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product/delete")
    public String delete(int id, HttpServletRequest request) {
        productRepository.deleteById(id);
        HttpSession session = request.getSession(); // 서버 측 저장소
//      session은 el표현식과 request 접근가능
        session.setAttribute("info","삭제완료");
        return "redirect:/";
//       ex) session 쓰는 예 = 로그인 인증정보
//       관련된 브라우저 다 끄면 사라짐

//      redirect:/는 Spring Framework에서 리다이렉트(redirect)를 수행하는 방법 중 하나
//      여기 return에 home을 적으면 안되는 이유
//      가방(request)이 없음. 상품을 담은 가방이 없기 때문에
    }

    @PostMapping("/product/update")
    public String update(@ModelAttribute Product product, HttpServletRequest request) {
        Product productlist = productRepository.update(product);
        request.setAttribute("productUpdate", productlist);
        return "redirect:/";
//      redirect:/는 Spring Framework에서 리다이렉트(redirect)를 수행하는 방법 중 하나
//      여기 return에 home을 적으면 안되는 이유
//      가방(request)이 없음. 상품을 담은 가방이 없기 때문에
    }

    @GetMapping("/product/{id}")
//    URL 매핑에서 {id}와 같이 URL 패스 변수가 명시적으로 표현되어 있다면,
//    해당 부분을 매개변수로 받아와야 하므로 @PathVariable 어노테이션을 사용
    public String detail(@PathVariable int id, HttpServletRequest request) {
//        쿼리스트링이랑은 다름 ? 로 들어오는 거랑 다르다

//        여기서 Product가 나올 수 있는 이유는?
//        goodsRepository.findById(id) 메서드가 호출되면 해당 id를 가진 상품 정보가 데이터베이스에서 조회되어
//        Goods 객체로 매핑되고, 그 결과로 Goods 객체인 goods가 생성되어 리턴
        Product product = productRepository.findById(id);
        request.setAttribute("product",product);
//        System.out.println(product.getId());
//        System.out.println(product.getName());
//        System.out.println(product.getPrice());
//        로그 확인 필수

        return "detail";
    }

    //    상품목록
    @GetMapping("/") // " / " 요청, 조회
    public String home(HttpServletRequest request) {
//        디스패처 서블릿 주입
//        메시지를 invoke 할 때,
//        톰캣한테 request,reponse을 디스패처 서블릿이 전달받아
//        find uri 컨트롤러 찾아냄
//        매개변수로 request 있으면 있으면 주입해줌
//        프론트 컨트롤러가 디스패처서블릿이라고 생각하면 됨

        List<Product> productList = productRepository.findAll();
        request.setAttribute("productList", productList);
        return "home";
    }
    // home이라는 페이지 돌려줌
    // 메인 페이지를 줘라


    //  상품등록
    @GetMapping("/write")
    public String writePage() {
        return "write";
    }
    //    write 페이지를 줘라


    //    첫번째 방법
    @PostMapping ("/product") // " / " 요청 , 등록
    public String write(String name, int price, int qty) {
        System.out.println("name : " + name);
        System.out.println("price : " + price);
        System.out.println("qty : " + qty);
        productRepository.save(name,price,qty);
        return "redirect:/";
    }
    //   product제품을 줄게 (모델명을 사용)
    //   주소가 같아도 요청 메서드가 다르면 다르게 인식


//    두번째 방법
//    @PostMapping ("/product") // " / " 요청
//    public void write(String name, int price, int qty, HttpServletResponse response) throws IOException {
//        System.out.println("name : " + name);
//        System.out.println("price : " + price);
//        System.out.println("qty : " + qty);
//        productRepository.save(name,price,qty);
//        response.sendRedirect("/");
//    }

}
