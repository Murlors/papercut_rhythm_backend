package com.example.papercut_rhythm_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
@MapperScan
public class PapercutRhythmBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PapercutRhythmBackendApplication.class, args);
    }

}
