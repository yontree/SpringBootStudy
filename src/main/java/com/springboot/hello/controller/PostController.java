package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/post-api")
public class PostController {
    
     //@RequestMapping 사용 예
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    //@RequestBody와 Map을 활용한 POST API구현
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, String> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " " + map.getValue() + "\n");
        });
        return sb.toString();
    }
}
