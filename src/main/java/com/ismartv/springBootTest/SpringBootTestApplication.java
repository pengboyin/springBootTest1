package com.ismartv.springBootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
//@Log4j2
@Slf4j(topic = "spring boot application ")
public class SpringBootTestApplication {
//	static Logger logger = LogManager.getLogger("SpringBootTestApplication");

	public static void main(String[] args) {
		log.info("app {} start", "spring boot test");
		SpringApplication.run(SpringBootTestApplication.class, args);
	}

}
