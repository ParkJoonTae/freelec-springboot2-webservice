//package com.jojoldu.book.springboot;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class IndexControllerTest {
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void 메인페이지_로딩(){
//        //when
//        String body = this.restTemplate.getForObject("/", String.class);
//
//        //then
//        assertThat(body).contains("spring boot web service");
//    }
//}
