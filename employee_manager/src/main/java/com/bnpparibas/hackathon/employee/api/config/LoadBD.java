package com.bnpparibas.hackathon.employee.api.config;

import com.bnpparibas.hackathon.employee.api.model.Employee;
import com.bnpparibas.hackathon.employee.api.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBD implements CommandLineRunner {

    EmployeeRepository employeeRepository;

    public LoadBD(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    	Employee emp1 = new Employee();
    	emp1.setEmailId("emailId 1");
    	emp1.setFirstName("firstName 1");
    	emp1.setId(1L);
    	emp1.setLastName("lastName 1");
    	employeeRepository.save(emp1);
    	
    	Employee emp2 = new Employee();
    	emp2.setEmailId("emailId 2");
    	emp2.setFirstName("firstName 2");
    	emp2.setId(2L);
    	emp2.setLastName("lastName 2");
    	employeeRepository.save(emp2);
    	
    	Employee emp3 = new Employee();
    	emp3.setEmailId("emailId 3");
    	emp3.setFirstName("firstName 3");
    	emp3.setId(3L);
    	emp3.setLastName("lastName 3");
    	employeeRepository.save(emp3);
    	
    	Employee emp4 = new Employee();
    	emp4.setEmailId("emailId 4");
    	emp4.setFirstName("firstName 4");
    	emp4.setId(4L);
    	emp4.setLastName("lastName 4");
    	employeeRepository.save(emp4);
    }
}