package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
//스캔 범위지정하지않으면 hello.core가 시작위치가 된다.
@Configuration
@ComponentScan( //@Component 애노테이션이 붙은 클래스를 스캔해서 스프링빈으로 등록
       // basePackages = "hello.core.member", //member만 스캔의 대상
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =Configuration.class))
public class AutoAppConfig {

    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
