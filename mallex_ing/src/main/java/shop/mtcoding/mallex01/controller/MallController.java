package shop.mtcoding.mallex01.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.mallex01.model.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MallController {

    @Autowired
    MallRepository mallRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    MallDTO mallDTO;

//    mall -------------------

    @GetMapping("/main")
    public String mainPage (HttpServletRequest request){
        List<Mall> mallList = mallRepository.findAll();
        request.setAttribute("mallList",mallList);
        return "main";
    }

    @GetMapping("/regist")
    public String registPage() {

        return "regist";
    }

    @GetMapping("/mall/{id}")
    public String detailPage(@PathVariable int id , HttpServletRequest request) {
        Mall product = mallRepository.findById(id);
        request.setAttribute("product",product);
        return "detail";
    }
    @PostMapping("/mall")
    public String regist(Mall mall) {
        mallRepository.save(mall);
        return "redirect:/main";
    }

    @PostMapping("/mall/update")
    public String update(Mall mall) {
        mallRepository.update(mall);
        return "redirect:/main";
    }

    @PostMapping("/mall/delete")
    public String delete(int id) {
        mallRepository.deleteById(id);
        return "redirect:/main";
    }


//    seller-----------------------



//    join ------------------------


    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        List<Mall> mallJoinList = mallRepository.findjoinAll();
        request.setAttribute("mallJoinList", mallJoinList);

        return "testmain";
    }

    @PostMapping("/test/save")
    public String join(@ModelAttribute Mall mall, @RequestParam("seller") String sellerName) {
        // 판매자 이름으로 판매자 엔티티 조회
        Seller seller = sellerRepository.findByName(sellerName);

        // Mall 엔티티에 판매자 정보 설정
        mall.setSeller(seller);

        // Mall 엔티티 저장
        mallRepository.save(mall);

        return "test";

    }

}
