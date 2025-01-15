package com.abhi.ModernWebApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ModernWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModernWebApplication.class, args);
	}

}
