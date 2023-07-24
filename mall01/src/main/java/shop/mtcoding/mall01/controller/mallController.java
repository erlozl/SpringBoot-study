package shop.mtcoding.mall01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.mall01.model.Product;
import shop.mtcoding.mall01.model.ProductDTO;
import shop.mtcoding.mall01.model.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class mallController {

     @Autowired
     ProductRepository productRepository;

     @GetMapping("/test")
     public ProductDTO test() {
         ProductDTO productDTO = productRepository.findByIdDTO(4);
         return productDTO;
     }

     @PostMapping("/product/delete")
     public String delete(int id) {
         productRepository.deleteById(id);
         return "redirect:/";
     }

     @PostMapping("/product/update")
     public String update(@ModelAttribute Product product) {
         productRepository.update(product);
         return "redirect:/";
     }

     @GetMapping("/product/{id}")
     public String detailPage(@PathVariable int id, HttpServletRequest request) {
         Product product = productRepository.findById(id);
         request.setAttribute("product", product);
         return "detail";
     }

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        List<Product> productList = productRepository.findAll();
        request.setAttribute("productList",productList);
        return "home";
    }
//    home이라는 페이지를 줘!

    @GetMapping("/write")
    public String writePage() {
        return "/write";
    }
//    writePage를 줘!

    @PostMapping("/product")
    public String write(String name, int price, int qty) {
        System.out.println("name :" + name);
        System.out.println("price :" + price);
        System.out.println("qty :" + qty);

        productRepository.save(name,price,qty);
        return "redirect:/";
    }
}
