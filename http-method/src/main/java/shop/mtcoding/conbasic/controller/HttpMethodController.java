package shop.mtcoding.conbasic.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

@RestController
public class HttpMethodController {

    @GetMapping("/req/get")
    public void methodGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("요청주소 : " + request.getRemoteAddr());
        System.out.println("요청주소 : " + request.getMethod());
        System.out.println("요청주소 : " + request.getHeader("User-Agent"));
        System.out.println("요청주소 : " + request.getRequestURI());
        System.out.println("쿼리스트링 : " + request.getQueryString());
        System.out.println("name : " + request.getParameter("name"));
        System.out.println("name : " + request.getParameter("password"));
//        response.setStatus(200);
//        response.sendRedirect("https://naver.com");
//        response.getWriter().println("hello everyone");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
        bw.write("hello everyone");
        bw.write("\n");
        bw.flush();
    }

//    localhost:8080/req/post
    @PostMapping("/req/post")
    public String methodPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("price"));
        System.out.println(request.getParameter("qty"));
        return "<h1>post 요청</h1>";
    }
//    이게 정석 - 1번째 방법 ( 톰캣이 해줌 )

//    BufferedReader br = request.getReader();
//    String value = " ";
//    while(true) {
//        String input = value + br.readline();
//          if(input = null) break;
//          value = value + input;
//    }
//     System.out.println(value)
//
//    String params[] = value.split("&");
//    String name = params[0].split("=")[1]
//    System.out.println(name)

//    2번째 방법

    @PostMapping("/req/post2")
    public String methodPost2(String username, String password) throws IOException {
        System.out.println("username : " + username);
        System.out.println("password : " + password);
        return "<h1>post 요청</h1>";
    }
//    이렇게 해도 됨
    @PutMapping("/req/put")
    public String methodPut() {
        return "<h1>put 요청</h1>";
    }

    @DeleteMapping("/req/delete")
    public String methodDelete() {
        return "<h1>delete 요청</h1>";
    }

}
