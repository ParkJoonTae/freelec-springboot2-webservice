package com.jojoldu.book.freelecspringboot2webservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = {MockMvc.class})
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 bean을 주입받는다.
    MockMvc mvc; // 웹mvc를 테스트할때 사용. 스프링 mvc테스트의 시작점. 이 클래스로 get, post등 api테스트 가능

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))   // mockmvc를 통해 /hello경로로 get요청
                .andExpect(status().isOk())    // OK: 200인지 아닌지 검증
                .andExpect(content().string(hello));    // 리턴값이 hello가 맞는지 검증
    }

    @Test
    public void helloDto_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)            // 요청 파라미터 설정. 값은 String만 허용
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name", is(name)))     // json 응답값을 필드별로 검증가능
                .andExpect((ResultMatcher) jsonPath("$.amount", is(amount)));
    }

}
