package shop.mtcoding.mall01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
//        이건 일명 소켓 - bufferedReader한 소켓

        String name = "홍길동";
//        이 name을 전달하고 싶으면 가방에 옮겨담아야 하는데
//        그것이 HttpServletRequest
        request.setAttribute("name",name);
//        무조건 키값으로 찾기!
//        view에서 el표현식으로 꺼낼 수 있다 이건 문법!!!!

        ArrayList<String> list = new ArrayList<>();
        list.add("바나나");
        list.add("딸기");
        list.add("참외");

        request.setAttribute("banana",list.get(0));
        request.setAttribute("ddalgi",list.get(1));
        request.setAttribute("chamwei",list.get(2));

        request.setAttribute("list",list);
//        이건 담아서 꺼내 쓰자


//        소켓을 통신할 때
//        BufferedWriter로 요청,
//        BufferedReader 읽음 요청정보에 버퍼리드에 있음( 이게 request)
//        응답을 할려면 BufferedWriter가 달리는데 이게 response 객체임
    return "hello";
    }
}
