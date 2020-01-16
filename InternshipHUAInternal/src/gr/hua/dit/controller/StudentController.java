package gr.hua.dit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.entity.Positions;

import gr.hua.dit.service.StudentService;

@Controller
@RequestMapping("/Student/")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/Internship_Request", method = RequestMethod.GET)
	public String newRequestForInternship(Model model, Principal principal) {
		String name = principal.getName();
		System.out.println(name);
		int id = Integer.parseInt(name);
		String department = studentService.getDepartment(id);
		System.out.println(department);
		List<Positions> positions = studentService.getDepartmentPositions(department);
		// add the customers to the model
		model.addAttribute("positions", positions);
		return "internshipRequest";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showStudentHomeMenu(Principal principal) {
		String name = principal.getName();
		System.out.println(name);
		int id = Integer.parseInt(name);
		boolean allowed = studentService.isAllowed(id);

		if (allowed == true) {
			return "studentMenu";
		} else {
			return "notAllowedStudentPage";
		}
	}

	@RequestMapping(value = "/applyForPosition", method = RequestMethod.GET)
	public String applyForPosition(Model model, @RequestParam String CurrentUpdate, Principal principal) {
		
		System.out.println(CurrentUpdate);
		int position_id = Integer.parseInt(CurrentUpdate);

		String name = principal.getName();
		System.out.println(name);
		int student_id = Integer.parseInt(name);
		String department = studentService.getDepartment(student_id);

		List<Positions> positions = studentService.getDepartmentPositions(department);
		// add the customers to the model
		model.addAttribute("positions", positions);
		studentService.savePosition(student_id, position_id);
		
		return "internshipRequest";

	}
}
