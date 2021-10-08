package com.example.DataJPA;

import com.example.DataJPA.repository.SalaryDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoEmployeeService(SalaryDao dao) {
        return (args) -> {
            //using salary dao

            dao.findBySalaryAndBonus(40000, 30000).stream()
               .forEach(it -> System.out.println(it.toString()));

        };
    }
}
