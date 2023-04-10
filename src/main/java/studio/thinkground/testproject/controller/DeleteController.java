package studio.thinkground.testproject.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get-api")
public class DeleteController {

    //db연동 전 연습용코드
    //http://localhost:8080/api/v1/get-api/delete/{variable}
    @DeleteMapping("/delete/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }
}
