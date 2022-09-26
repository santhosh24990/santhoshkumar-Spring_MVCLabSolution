package com.gl.fest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.fest.doa.Studentdoa;
import com.gl.fest.model.Student;



@Controller
@RequestMapping("students")
public class StudentController {
	@Autowired
	Studentdoa studentDao;

	@GetMapping("list")
	public String showStudents(Model model) {
		List<Student> students = studentDao.listall();
		model.addAttribute("students", students);
		return "student-list";
	}



	@GetMapping("showStudentForm")
	public String showStudentForm(Model model) {
		Student student =new Student();
		model.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("save")
	public String saveStudent(Model model,
			@ModelAttribute("student")Student student) {
		studentDao.savestudent(student);
		return "redirect:/students/list";
	}

	@GetMapping("update")
	public String updateStudent(Model model,
			@RequestParam("id") int id) {
		 Student student = studentDao.findbyid(id);
		 System.out.println(student);
		 model.addAttribute("student", student);
		return "student-form";
	}


	@GetMapping("delete")
	public String deleteStudent(Model model,
			@RequestParam("id") int id) {
		 studentDao.deletestudent(id);
		 return "redirect:/students/list";
	}

}