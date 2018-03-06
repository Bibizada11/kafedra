package com.example.demo.controllers;

import com.example.demo.models.Teacher;
import com.example.demo.reposotories.TaecherRepository;
import com.example.demo.models.Teacher;
import com.example.demo.reposotories.TaecherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/demo")
public class TaecherController {
    @Autowired
    private TaecherRepository TaecherRepository ;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("teacher",new Teacher());
        return "teacher_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("teacherr",new Teacher());
        return "update";
    }
    @PostMapping("/add")
    public String addTeacher(@ModelAttribute Teacher author){
        TaecherRepository.save(author) ;

        return "redirect:/demo/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody Iterable<Teacher> allTeachers(){
        return TaecherRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allTeachers2(Model model){
        List<Teacher> teachers = (List<Teacher>) TaecherRepository.findAll();
        model.addAttribute("teacher", teachers) ;
        return "teachers" ;
    }

    @PostMapping("/adds")
    public String addsTeacher(@ModelAttribute Teacher teacher){
        Teacher teacher1 = new Teacher();
        teacher1.setId(a);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        TaecherRepository.save(teacher1) ;

        return "redirect:/demo/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Teacher> teacher = (Optional <Teacher> ) TaecherRepository.findById(id);
        model.addAttribute("teacherr",teacher);
        return new ModelAndView("update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        TaecherRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all");
    }
}
