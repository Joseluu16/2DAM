package com.SpringBoot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class DemoApplication {
  

    @GetMapping("/plantilla1")
    public String getPlantilla1() {
        return "template1"; // Renderiza la plantilla1.html
    }

    @GetMapping("/plantilla2")
    public String getPlantilla2() {
        return "template2"; // Renderiza la plantilla2.html
    }
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
                       
	}
}



