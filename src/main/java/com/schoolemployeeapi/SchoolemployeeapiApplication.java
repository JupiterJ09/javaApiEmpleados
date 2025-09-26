package com.schoolemployeeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner; 



@SpringBootApplication
public class SchoolemployeeapiApplication implements CommandLineRunner { // Implementa la interfaz

    // Elimina 'static'. Ahora es una variable de instancia.
    @Autowired 
    private Greeting greeting;

    public static void main(String[] args) {
        // Esta línea es la única que debe estar aquí
        SpringApplication.run(SchoolemployeeapiApplication.class, args);
    }

    // Este método se ejecuta DESPUÉS de que Spring haya inicializado todo.
    @Override
    public void run(String... args) throws Exception {
        // Ahora, 'greeting' ya no es null y puedes usarlo.
        greeting.sayHello();
    }
}