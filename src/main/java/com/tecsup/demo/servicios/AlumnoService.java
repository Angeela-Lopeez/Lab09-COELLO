package com.tecsup.demo.servicios;

import com.tecsup.demo.modelo.entidades.Alumno;
import java.util.List;

public interface AlumnoService {
    List<Alumno> listar();
    void grabar(Alumno alumno);
    Alumno buscar(String id);
    void eliminar(String id);
}