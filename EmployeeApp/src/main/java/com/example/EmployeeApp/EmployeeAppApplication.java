package com.example.EmployeeApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title = "The SoftCodeMath Academy EMS App",
				description = "Backend Rest APIs for Employee Management System",
				version = "v1.0",
				contact = @Contact(
						name="Adebisi Ramadan",
						email = "adebisiramadan9@gmail.com"
				)
		)
)
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
	}

	// URL to access the swagger UI
	// http://localhost:8080/swagger-ui/index.html
}
