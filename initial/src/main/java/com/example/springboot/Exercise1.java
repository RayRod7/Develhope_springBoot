package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

//Exercise 1.1
@RestController
public class Exercise1 {



    @GetMapping("/hello")
    public String index() {
        return "Hello World!";
    }

    //Exercise 1.2
    @GetMapping("/greetings")
    public ResponseEntity<?> index2() {
        return ResponseEntity.ok("Good Afternoon!");
    }

}

//Exercise 1.3
@RestController
class InfoController {

    @GetMapping("/info")
    public ResponseEntity<?> index1_3() {
        return ResponseEntity.ok("info 200 ok");
    }
}

//Exercise 1.4
@RestController
class RandomController {

    @GetMapping("/random")
    public ResponseEntity<?> index1_4() {
        boolean random = new Random().nextBoolean();
        if (!random) {
            return ResponseEntity.badRequest().body("Random is false");
        } else {
            return ResponseEntity.ok("Random is true");
        }
    }
}

