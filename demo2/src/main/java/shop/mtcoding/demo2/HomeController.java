package shop.mtcoding.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
//    스프링의 컴포넌트 스캔 기능에 의해
//    스프링 IoC(Inversion of Control) 컨테이너에 등록
//    IoC(제어의 역전)컨테이너 등록 됨 - HomeController
//    박스(컨테이너)에 자기가 new 한 것들을 놔두는 것

//    home() 요청
//    1) - localhost:8080/home -> 순수하게 뒷부분만 파싱을 함
//    2) Ioc컨테이너에서 떠있는 객체들을 다 찾아냄, 지금은 /home을 찾아낸다는 것
//    3) home이 있는 getMapping을 다 찾아냄 <- Ioc 컨테이너에서 /home으로 등록된 깃발 찾음
//    4) 호출(invoke)

//    home() 응답
//    1) - @Controller(리턴 값 파일로 인식) - viewResolver동박,
//       - @RestController(리턴 값을 데이터로 인식) - 메시지컨버터 동작
//       둘 중에 하나를 분석
//    2)

    //    여기 뒤에 /home은 파일이 아님 그냥 주소임
    @GetMapping("/home")
    public String home() {
        return "home"; // ViewResolver 클래스 발동
//        webapp/WEB-INF/views/home.jsp ViewResolver 설정하는 것임
//        프리픽스임
    }
}
