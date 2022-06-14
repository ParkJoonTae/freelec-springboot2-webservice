package com.jojoldu.book.springboot.dto;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);  //  assertThat: assertj 테스트 라이브러리 검증 메서드
        assertThat((dto.getAmount())).isEqualTo(amount);    //  isEqualTo: 동등 비교 메서드
    }
}
