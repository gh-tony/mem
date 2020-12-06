package cn.com.sabs.mem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"cn.com.sabs.mem.*"})
@SpringBootApplication
public class MemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemApplication.class, args);
    }

}
