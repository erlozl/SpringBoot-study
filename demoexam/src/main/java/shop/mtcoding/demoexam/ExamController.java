package shop.mtcoding.demoexam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class ExamController {

    @GetMapping("/ddfdfsfefe")
    public String Exam() {

        return "Exam";
    }
}
