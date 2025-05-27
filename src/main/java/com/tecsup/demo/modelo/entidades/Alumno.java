package com.tecsup.demo.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @Column(name = "chrAluCodigo", length = 10)
    private String id;

    @Column(name = "vchAluNombres", length = 50)
    @NotNull
    @Size(min = 2, max = 50)
    private String nombres;

    @Column(name = "vchAluApellidos", length = 50)
    @NotNull
    @Size(min = 2, max = 50)
    private String apellidos;

    @Column(name = "dtmAluFechaNac")
    private LocalDate fechaNacimiento;

    @Column(name = "chrAluSexo", length = 1)
    @NotNull
    private String sexo;

    public Alumno() {}

    public Alumno(String id, String nombres, String apellidos, LocalDate fechaNacimiento, String sexo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id='" + id + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}