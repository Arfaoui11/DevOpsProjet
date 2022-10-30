package com.esprit.examen;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableScheduling
@EnableSwagger2
@SpringBootApplication
@RestController
public class TpAchatProjectApplication {
	@Bean
	public ModelMapper modelMapper(){

		return new ModelMapper();
	}



	public static void main(String[] args) {
		SpringApplication.run(TpAchatProjectApplication.class, args);
}

	@GetMapping("/")
	public String home(){
		return "Welcome Home new mahdi change vendredi";
	}
}
