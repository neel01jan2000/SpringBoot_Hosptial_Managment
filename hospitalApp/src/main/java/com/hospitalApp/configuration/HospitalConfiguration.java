package com.hospitalApp.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class HospitalConfiguration {

	
//	OpenAPI is one of the class of Swagger 
	@Bean
	public OpenAPI userOpenApi() {
		
		Server s=new Server();
		s.setUrl("http://localhost:8080");
		s.setDescription("Development Environment");
	
//		to show name of developer or to whom to contact
		Contact c = new Contact();
		c.setName("Allen");
		c.setUrl("http:/sandbox.com");
		
//		to show license
		License li = new License();
		li.setName("MIT Licence");
		li.setUrl("https://choosealincense.com/license.com/license/mit/");
		
		Info info = new Info();
			info.license(li);
			info.contact(c);
		
//		method chaining way
//			Info info = new Info().license(li).contact(c);
			
		return new OpenAPI().info(info).servers(List.of(s));
		
	}
}
