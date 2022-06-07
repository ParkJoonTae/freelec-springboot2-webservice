package com.jojoldu.book.freelecspringboot2webservice.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {     // 사용자의 권한을 관리하는 enum클래스
    GUEST("ROLE_GUEST", "손님"),  // 권한 앞에 ROLE_이 있어야만 한다.
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

}
