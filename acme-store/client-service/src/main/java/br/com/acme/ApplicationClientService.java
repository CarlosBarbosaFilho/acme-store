package br.com.acme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApplicationClientService {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClientService.class, args);
    }
}
