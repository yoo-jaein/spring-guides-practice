package com.example.restservice.config;

import com.example.restservice.domain.Employee;
import com.example.restservice.domain.Order;
import com.example.restservice.enumeration.Status;
import com.example.restservice.repository.EmployeeRepository;
import com.example.restservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LoadDatabaseConfig {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("Gaga", "Kim", "burglar"));
            employeeRepository.save(new Employee("Nana", "Lee", "thief"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));

        };
    }
}
