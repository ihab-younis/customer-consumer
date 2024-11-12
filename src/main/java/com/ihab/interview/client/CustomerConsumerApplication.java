package com.ihab.interview.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomerConsumerApplication {
    static Logger logger = LoggerFactory.getLogger(CustomerConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CustomerConsumerApplication.class, args);

        String allCustomersJson = restTemplate().getForObject("http://localhost:8080/customer/v1/all", String.class);
        logger.info("All Customers response : {}", allCustomersJson);
    }

    @Bean
    public static RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
