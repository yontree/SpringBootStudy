package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/delete-api")
public class DeleteController {

    //@PathVariable을 활용한 DELETE 메서드 구현
    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable("variable") String variable) {
        return variable;
    }

    //@RequestParam을 활용한 DELETE 메서드 구현
    @DeleteMapping(value = "/request1")
    public String getRequestParam(@RequestParam("email") String email) {
        return "email : " + email;
    }
}
