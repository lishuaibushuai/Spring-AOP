package cn.edu.ruc;

import cn.edu.ruc.secondAOP.PersonProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Lishuai
 * @Date: Created on 2018/4/25
 */
@SpringBootApplication
public class Application {

    @Autowired
    private Speakable personSpring;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner1(ApplicationContext ctx) {
        return args -> {
            // spring aop
            System.out.println("******** spring aop ******** ");
            personSpring.sayHi();
            personSpring.sayBye();
            System.exit(0);
        };
    }

    @Bean
    public CommandLineRunner commandLineRunner2(ApplicationContext ctx) {
        return args -> {
            // jdk dynamic proxy
            System.out.println("******** jdk dynamic proxy ******** ");
            Speakable jdkProxy = PersonProxyFactory.newJdkProxy();
            jdkProxy.sayHi();
            jdkProxy.sayBye();
        };
    }
}
