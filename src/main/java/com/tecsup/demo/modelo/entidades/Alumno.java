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
    @Column(name = "chr_alu_codigo", length = 10)
    private String codigo;

    @Column(name = "vch_alu_nombres", length = 50)
    @Size(max = 50, message = "Los nombres no deben exceder los 50 caracteres")
    private String nombres;

    @Column(name = "vch_alu_apellidos", length = 50)
    @Size(max = 50, message = "Los apellidos no deben exceder los 50 caracteres")
    private String apellidos;

    @Column(name = "dtm_alu_fecha_nac")
    private LocalDate fechaNacimiento;

    @Column(name = "chr_alu_sexo", length = 1)
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