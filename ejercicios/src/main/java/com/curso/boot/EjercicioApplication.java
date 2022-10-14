package com.curso.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.curso.controller","com.curso.service"})
public class EjercicioApplication {

  public static void main(String[] args) {
    SpringApplication.run(EjercicioApplication.class, args);
  }

}

