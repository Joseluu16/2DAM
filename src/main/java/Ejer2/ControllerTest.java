/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2;

import Ejer2.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jolun
 */
@Controller
public class ControllerTest {
     @Autowired
    private alumnoRepository alumnorepository;
    
    @PostMapping("/formulario")
    public String guardarAlumno(Alumno alumno){
        alumnorepository.save(alumno);
        return "redirect:/";
    }
    @GetMapping("/")
    public String listaPersonas(Model model,@PageableDefault(size=5) Pageable p) {
        
        Page<Alumno> alumnos = alumnorepository.findAll(p);
        model.addAttribute("alumnos", alumnos);
        return "index";
    }
    @GetMapping("/formulario")
    public String form(Model model){
        model.addAttribute("alumno", new Alumno());
        return "agregar";
    }
}
