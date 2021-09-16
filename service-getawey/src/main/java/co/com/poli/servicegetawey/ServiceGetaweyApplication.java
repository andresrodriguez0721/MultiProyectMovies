package co.com.poli.servicegetawey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceGetaweyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGetaweyApplication.class, args);
    }

}
