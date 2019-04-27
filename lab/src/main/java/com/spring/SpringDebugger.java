package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbs 2019/4/27
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.spring")
@RestController
public class SpringDebugger {

    public static void main(String[] args) {
        SpringApplication.run(SpringDebugger.class, args);
    }

    @RequestMapping("/a.json")
    public Integer test(@RequestParam("num") String num) {
        return Integer.valueOf(num);
    }
}
