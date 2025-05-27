package com.tecsup.demo.controladores;

import com.tecsup.demo.modelo.entidades.Alumno;
import com.tecsup.demo.servicios.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

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

    @GetMapping("/form/{id}")
    public String editar(@PathVariable("id") String id, Map<String, Object> model) {
        Alumno alumno = servicio.buscar(id);
        if (alumno == null) {
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

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id) {
        if (id != null && !id.isEmpty()) {
            servicio.eliminar(id);
        }
        return "redirect:/alumnos/listar";
    }
}