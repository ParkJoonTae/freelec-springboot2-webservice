package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity      // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable()
        //h2-console화면을 사용하기 위해 해당 옵션들 disable
                .and().authorizeRequests()
                //URL별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**",
                        "/js/**", "/h2-console/**","/profile").permitAll()
                //권한 관리 대상 지정. "/"등 지정된 URL들은 permitAll을 통해 전체열람권한.
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()).anyRequest().authenticated().and()
                // 설정된 값들 이외 나머지 URL들을 나타낸다. authenticated으로 나머지 URL들은 모두 인증된 사용자들에게만 허용
                .logout().logoutSuccessUrl("/")
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
