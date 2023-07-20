package shop.mtcoding.productexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.productexam.model.Goods;
import shop.mtcoding.productexam.model.GoodsRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsRepository goodsRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Goods> goodslist = goodsRepository.findAll();
        model.addAttribute("goodsList", goodslist);
        return "home";
    }

    @GetMapping("/goods")
    public String goodsRegist() {

        return "goodsRegist";
    }

    @GetMapping("/rs/{id}")
    public String detail(@PathVariable Integer id, HttpServletRequest request) {
        Goods goods =  goodsRepository.findById(id);
        request.setAttribute("goods", goods);
        return "detail";
    }

    @PostMapping("/update")
    public String edit(@ModelAttribute Goods goods, HttpServletRequest request) {
        Goods goodUpdate = goodsRepository.update(goods);
        request.setAttribute("goods", goodUpdate);
        return "detail";
    }

    @PostMapping("/goodsList")
    public String goodsList(String name, Integer price, Integer qty) {
        goodsRepository.save(name, price, qty);
        return "redirect:/";
    }
}
