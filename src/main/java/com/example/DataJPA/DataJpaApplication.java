package com.example.DataJPA;

import com.example.DataJPA.entity.Employee;
import com.example.DataJPA.enums.Gender;
import com.example.DataJPA.repository.EmployeeRepository;
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
	public CommandLineRunner demoEmployeeService(EmployeeRepository repository) {
		return (args) -> {
			//save a employee
			Employee employee = Employee.builder()
										.firsName("FirstName")
										.lastName("LastName")
										.address("addressLine1")
										.age(20)
										.gender(Gender.MALE)
										.build();

			repository.save(employee);

			//fetch all the employee
			repository.findAll()
					  .stream()
					  .forEach(it -> System.out.println(it.toString()));

			//fetch employee by id
			Employee employeeFromDB = repository.getById(1L);
			System.out.println(employeeFromDB.toString());

			//fetch employee by last name
			repository.findEmployeeByLastName("LastName")
					  .stream()
					  .forEach(it -> System.out.println(it.toString()));

		};
	}

}
