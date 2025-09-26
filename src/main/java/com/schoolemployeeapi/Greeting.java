package com.schoolemployeeapi;

import org.springframework.stereotype.Component;

@Component
public class Greeting{
    String message = "¡Hola, mundo primer cambio!";

    public void sayHello(){
        System.out.println(message);
    }
}