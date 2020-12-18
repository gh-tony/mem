package cn.com.sabs.mem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.mybatis.spring.annotation.MapperScan;

@ComponentScan(basePackages = {"cn.com.sabs.mem.*"})
@MapperScan("cn.com.sabs.mem.mapper")
@SpringBootApplication
public class MemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemApplication.class, args);
    }

}
