package com.coderclase11.clientes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Column(name = "DNI")
    @Id
    private Long dni;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Transient //Hace que no se asocie a una columna de la base de datos.
    private int edad;

    @JsonIgnore // Hace que no se devuelva la fecha de nac. en el json.
    @Column(name = "FECHA_DE_NACIMIENTO")
    private LocalDate fechaNacimiento;

    //Constructor vacío
    public Cliente() {
    }

    // Contructor
    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento, Long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }

    //getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
