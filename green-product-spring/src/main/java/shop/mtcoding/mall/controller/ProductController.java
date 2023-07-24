package shop.mtcoding.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.mtcoding.mall.model.Product;
import shop.mtcoding.mall.model.ProductDTO;
import shop.mtcoding.mall.model.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ResponseBody
    @GetMapping("/test")
    public ProductDTO test(){
        ProductDTO productDTO = productRepository.findByTest(3);
        return productDTO;
    }

    @PostMapping("/product/delete")
    public String delete(int id, HttpServletRequest request){
        productRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request){
        System.out.println("id : "+id);
        Product product = productRepository.findById(id);
        request.setAttribute("p", product);
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQty());
        return "detail";
    }

    @GetMapping("/")
    public String home(HttpServletRequest request){
        List<Product> productList = productRepository.findAll();
        request.setAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/write")
    public String writePage(){
        return "write";
    }

    // http://localhost:8080/product (GET X) (POST o)
    @PostMapping("/product")
    public void write(String name, int price, int qty, HttpServletResponse response) throws IOException {
        System.out.println("name : "+name);
        System.out.println("price : "+price);
        System.out.println("qty : "+qty);

        productRepository.save(name, price, qty);

        // 컨트롤러의 메서드를 재호출하는 방법, 버튼을 눌렀을 때 응답하는 일
//        => 폼(Form)의 내용을 서버로 전송
        response.sendRedirect("/");
        //return "redirect:/";
    }
}
