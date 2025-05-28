package com.tecsup.demo.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @NotNull
    @Column(name = "chrAluCodigo", length = 10)
    private String codigo;

    @Column(name = "vchAluNombres", length = 50)
    @Size(max = 50, message = "Los nombres no deben exceder los 50 caracteres")
    private String nombres;

    @Column(name = "vchAluApellidos", length = 50)
    @Size(max = 50, message = "Los apellidos no deben exceder los 50 caracteres")
    private String apellidos;

    // CORREGIDO: Cambié el nombre de la columna para que coincida con la BD original
    @Column(name = "dtmAluFechaNac")
    private LocalDate fechaNacimiento;

    @Column(name = "chrAluSexo", length = 1)
    @Size(max = 1, message = "El sexo debe ser un solo caracter")
    private String sexo;

    public Alumno() {
    }

    public Alumno(String codigo, String nombres, String apellidos, LocalDate fechaNacimiento, String sexo) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
                "codigo='" + codigo + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}