package shop.mtcoding.mallexam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/sub")
    public String sub() {
        return "sub";
    }

}
