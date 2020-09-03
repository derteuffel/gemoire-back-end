package com.Gemoire.Gemoire;

import com.Gemoire.Gemoire.config.FileServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class GemoireApplication {
	@Resource
	private FileServices fileServices;

	public static void main(String[] args) {
		SpringApplication.run(GemoireApplication.class, args);
	}

	/*@Override
	public void run(String... arg) throws Exception {
		fileServices.deleteAll();
		fileServices.init();
	}*/

}
