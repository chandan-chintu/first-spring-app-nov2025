package com.firstspringboot.example.first_spring_app;

import com.firstspringboot.example.first_spring_app.model.Address;
import com.firstspringboot.example.first_spring_app.model.Employee;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class FirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
		System.out.println("Hello everyone welcome to spring app!");

		// tight coupling example
//		Employee emp1 = new Employee();
//		emp1.id=111;
//		emp1.name="Ajay";
//		emp1.email="ajay123@gmail.com";
//		emp1.designation="developer";
//
//		Address adrs1 = new Address();
//		adrs1.doorNo=999;
//		adrs1.streetName="old street";
//		adrs1.city="old city";
//
//		emp1.address=adrs1;
//
//		System.out.println("emp1 is : "+emp1);
//		System.out.println("adrs1 is : "+adrs1);
//
//		adrs1.doorNo=444;
//		adrs1.streetName="new street";
//		adrs1.city="new city";
//
//		System.out.println("emp1 is after adrs1 change is : "+emp1);
//		System.out.println("adrs1 is after adrs1 change is : "+adrs1);

		// loose coupling using setter injection

		Employee emp2 = new Employee();
		emp2.setId(333);
		emp2.setName("Vijay");
		emp2.setEmail("vijay123@gmail.com");
		emp2.setDesignation("tester");

		Address adrs2 = new Address();
		adrs2.setDoorNo(345);
		adrs2.setStreetName("old street");
		adrs2.setCity("old city");

		emp2.setAddress(adrs2);

		System.out.println("emp2 is : "+emp2);
		System.out.println("adrs2 is : "+adrs2);

		emp2.getAddress().setDoorNo(999);
		emp2.getAddress().setStreetName("new street");
		emp2.getAddress().setCity("new city");

		System.out.println("emp2 after adrs2 chnage is : "+emp2);
		System.out.println("adrs2 after adrs2 chnage  is : "+adrs2);

		// loose coupling using constructor injection
		Address adrs3 = new Address(567,"old street","old city");
		Employee emp3 = new Employee(234,"Sanjay","sanjay123@gmail.com","tester",adrs3);

		System.out.println("emp3 is : "+emp3);
		System.out.println("adrs3 is : "+adrs3);

		emp3.getAddress().setCity("new city");
		emp3.getAddress().setStreetName("new street");

		System.out.println("emp3 after adrs3 chnage is : "+emp3);
		System.out.println("adrs3 after adrs3 chnage  is : "+adrs3);
	}

}
