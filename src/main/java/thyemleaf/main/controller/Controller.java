package thyemleaf.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import thyemleaf.main.entities.Student;
import thyemleaf.main.services.StudentService;


@org.springframework.stereotype.Controller
public class Controller {

	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/registrationpage")
	public String getRegistration(Model model) {

		model.addAttribute("reg_data", new Student());
		return "registration";
	}
	
	@PostMapping("/registartionfrom")
	public String insertdata(@ModelAttribute("reg_data") Student student,Model model) {
		boolean flag =studentService.addDetails(student);
		if(flag) {
			model.addAttribute("Succefully", "Succefully data add !!!");
			return "login";
		}
		else {
			model.addAttribute("unsuccefully","data do not  add !!!");
			return "registration";
		}
		
	}
	

	@GetMapping("/loginpage")
	public String getLogin(Model model) {
		model.addAttribute("login_data", new Student());
		return "login";
	}
	
	@PostMapping("/loginform")
	public String getdata(@ModelAttribute("login_data") Student student, Model model) {
		Student stud =studentService.loginstudent(student.getEmail(), student.getPassword());
		if(stud!=null) {
			model.addAttribute("stud_name",stud.getName());
			return "Profile";
		}
		else {
			model.addAttribute("Error","Login Unsucsefull !!!");
			return"login";
		}
				
	}
	
	@GetMapping("/logout")
	public String logoutmethod(HttpSession session) {
	    session.invalidate(); 
	    return "redirect:/loginpage"; 
	}
	
	
}
