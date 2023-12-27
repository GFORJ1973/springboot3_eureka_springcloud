package br.com.hgl.msclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EntityScan(basePackages = "br.com.hgl.msclientes.domain")
@SpringBootApplication
@EnableDiscoveryClient

public class MsclientesApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsclientesApplication.class, args);
    }

}
