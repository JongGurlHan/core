package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //A사용자 10000원 주문
        int userAprice = statefulService1.order("userA", 10000);
        //B사용자 20000원 주문
        int userBpRICE = statefulService2.order("userB", 20000);

        //사용자 A 주문금액 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = " + userAprice);

       // Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        StatefulService statefulService(){
            return new StatefulService();
        }
    }



}