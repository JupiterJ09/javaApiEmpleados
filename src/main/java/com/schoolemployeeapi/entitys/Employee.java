package com.schoolemployeeapi.entitys;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String correo;
    private String departament;
    private String ocupacion;

    public Employee(){

    }

    public Employee(String firstname, String lastName, String correo, String departament, String ocupacion){

        this.firstName = firstname;
        this.lastName = lastName;
        this.correo = correo;
        this.departament = departament;
        this.ocupacion = ocupacion;

    }


    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


    public String getLastName(){
       return this.lastName;
    }


    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getCorreo(){
        return this.correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getDepartament(){
        return this.departament;
    }

    public void setDepartament(String departament){
        this.departament = departament;
    }

    public String getOcupacion(){
        return this.ocupacion;
    }

    public void setOcupacion(String ocupacion){
        this.ocupacion = ocupacion;
    }

    public String getFullName(){

        return this.firstName + " " + this.lastName;
    }



    
}
