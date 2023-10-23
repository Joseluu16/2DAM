/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jolun
 */
@Controller
public class ControllerTest {
    @Autowired
    private alumnoRepository alumnoRepository;

    @GetMapping("/")
    public String listarAlumnos(Model model) {
        List<Alumno> alumnos = alumnoRepository.findAll();
        model.addAttribute("alumnos", alumnos);  // Debe ser "alumnos" en lugar de "alumno"
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alumno", new Alumno());  // Debe ser "alumno" en lugar de "alumnos"
        return "agregar";
    }

    @PostMapping("/agregar")
    public String agregarAlumno(@ModelAttribute Alumno alumno) {
        alumnoRepository.save(alumno);
        return "redirect:/";
    }
}
