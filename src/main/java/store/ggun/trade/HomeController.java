package store.ggun.trade;


import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HomeController {


    @GetMapping("/")
    public String Home(){

        LocalDateTime now = LocalDateTime.now();
        return "Hello trade! 날짜 :  " + now;
    }
}
