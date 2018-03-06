package com.example.demo.controllers;
import com.example.demo.models.Student;
import com.example.demo.models.Teacher;
import com.example.demo.models.Student;
import com.example.demo.reposotories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping(path = "/book")
public class StudentController {
    @Autowired
    private StudentRepository StudentRepository;
    private long a;

    @GetMapping("/main")
    public String allstudent(Model model){
        List<Student> students = (List<Student>) StudentRepository.findAll();
        model.addAttribute("students",students);
        return "students";
    }

    @RequestMapping("/addd")
    public String showFormmm(Model model){
        model.addAttribute("studentt",new Student());
        return "studupdate";
    }

    @GetMapping("/add")
    public String studForm(Model model){
        model.addAttribute("student",new Student());
        return "student_add_form";
    }

    @GetMapping("/main2")
    public @ResponseBody Iterable<Student> allstudents(){
        return StudentRepository.findAll() ;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Student student){
        StudentRepository.save(student);
        return "redirect:/student/main";
    }

    @PostMapping("/adds")
    public String addsStuds(@ModelAttribute Student student){
        Student student1 = new Student();
        student1.setId(a);
        student1.setstudName(student.getstudName());
        student1.setYear(student.getYear());
        StudentRepository.save(student1) ;

        return "redirect:/student/main" ;
    }

    @RequestMapping(value = "/updatestud",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Student> student = (Optional <Student> ) StudentRepository.findById(id);
        model.addAttribute("studentt",student);
        return new ModelAndView("studupdate");
    }

    @RequestMapping(value = "/deletestud",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        StudentRepository.deleteById(idd);
        return new ModelAndView("redirect:/student/main");
    }
}

