package com.tecsup.demo.controladores;

import com.tecsup.demo.modelo.entidades.Alumno;
import com.tecsup.demo.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("alumno")
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService servicio;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Alumnos");
        model.addAttribute("alumnos", servicio.listar());
        return "alumnoListarView";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {
        Alumno alumno = new Alumno();
        model.put("alumno", alumno);
        model.put("titulo", "Formulario de Alumno");
        return "alumnoFormView";
    }

    @GetMapping("/form/{codigo}")
    public String editar(@PathVariable(value = "codigo") String codigo, Map<String, Object> model) {
        Alumno alumno = null;
        if (codigo != null && !codigo.isEmpty()) {
            alumno = servicio.buscar(codigo);
        } else {
            return "redirect:/alumnos/listar";
        }
        model.put("alumno", alumno);
        model.put("titulo", "Editar Alumno");
        return "alumnoFormView";
    }

    @PostMapping("/form")
    public String guardar(@Valid Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Alumno");
            return "alumnoFormView";
        }
        servicio.grabar(alumno);
        status.setComplete();
        return "redirect:/alumnos/listar";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable(value = "codigo") String codigo) {
        if (codigo != null && !codigo.isEmpty()) {
            servicio.eliminar(codigo);
        }
        return "redirect:/alumnos/listar";
    }
}