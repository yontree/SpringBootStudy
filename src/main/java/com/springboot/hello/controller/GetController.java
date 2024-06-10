package com.springboot.hello.controller;

import com.springboot.hello.data.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    //RequestMapping을 사용한 메서드 구현
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String GetHello() {
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Hello World";
    }
    
    //매개변수가 없는 GET 메서드 구현
    @GetMapping(value = "/name")
    public String getName() {
        LOGGER.info("getName 메서드가 호출되었습니다.");
        return "Flature";
    }
    
    //@PathVariable을 활용한 GET메서드 구현
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable("variable") String variable) {
        LOGGER.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }

    //@PathVariable에 변수명을 매핑하는 방법
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    //@RequestParam을 활용한 GET 메서드 구현
    @Operation(summary = "GET 메서드 예제", description = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/request1")
    public String getRequetParam1(@Parameter(description = "이름", required = true) @RequestParam("name") String name
                                ,@Parameter(description = "이메일", required = true) @RequestParam("email") String email
                                ,@Parameter(description = "회사", required = true) @RequestParam("organization") String organization) {
        return name + " " + email + " " + organization;
    }

    //@RequestParam과 Map을 조합한 GET 메서드 구현
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //DTO 객체를 활용한 GET 메서드 구현
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }

}
