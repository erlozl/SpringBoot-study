package shop.mtcoding.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        String name = "홍길동";
        request.setAttribute("gildonggildong",name);
//        view에서 찾을때는 "name"있는 곳에 네임명을 사용해야 함

        List<String> list = new ArrayList<>();
        list.add("바나나");
        list.add("사과");

        request.setAttribute("banana", list.get(0));
        request.setAttribute("apple", list.get(1));

        request.setAttribute("fruitlist",list);

        return "hello";
    }
}
