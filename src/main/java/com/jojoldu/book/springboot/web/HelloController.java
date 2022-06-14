package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json을 반환하는 컨트롤러로 만든다. 예전 responsebody를 메소드마다 썼던 것을 한번에 사용할수 있게한 것
public class HelloController {

    @GetMapping("/hello") // ®
    public String hello() {
        return "hello" ;
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,     // 외부에서 api로 넘긴 파라미터를 가져온다
                        @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
