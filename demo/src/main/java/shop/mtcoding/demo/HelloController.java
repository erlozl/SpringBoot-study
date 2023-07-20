package shop.mtcoding.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

// Controller 진입점
@RestController
// 소켓통신의 시작
public class HelloController {

//    getMapping("/")하면 http://localhost:8080 url이 만들어짐
    @GetMapping("/")
    public String home() {
        return "home";
    }

//    http://localhost:8080/hello
//    리플렉션해서 getMapping을 찾아가서 주소를 찾아감
//    구체적인 클래스 타입을 알지 못해도 그 클래스의
//    메소드, 타입, 변수들에 접근할 수 있도록 해주는 자바 API
    @GetMapping("/hello")
    public String hello() {
        return "<h1>hello</h1>";
    }

    @GetMapping("/check")
    public void check() {
        System.out.println("/check 호출됨");
    }
//    void 타입을 반환하면 어떠한 데이터도 응답으로 전송하지 않는다.

    @GetMapping("/random/number")
    public String random() {
        Random r = new Random();
        Integer num = r.nextInt(5);
        return "<h1>" + num.toString()+ "</h1>";
    }
}
