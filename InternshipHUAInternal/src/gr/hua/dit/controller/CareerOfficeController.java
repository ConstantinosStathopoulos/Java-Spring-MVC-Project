package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.entity.Positions;
import gr.hua.dit.entity.Student;
import gr.hua.dit.service.OfficeService;
import gr.hua.dit.service.StudentService;

@Controller
@RequestMapping("/CareerOffice/")
public class CareerOfficeController {
	
	//injecting student service instead of studentdao
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
    public String listStudents(Model model) {
		// get students from dao
		List<Student> students = studentService.getStudents();    
		
		// add the students to the model
		model.addAttribute("students", students);
		
		return "list-students";
    }
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	   public String redirect() {
	      return "redirect:list";
	   }
	
	@RequestMapping(value = "/redirectHome", method = RequestMethod.GET)
	   public String redirectHome() {
	      return "redirect:/CareerOffice/";
	   }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	   public String showOfficeMenu() {
	      return "careerOfficeMenu";
	   }
		
		
	@Autowired
	  private OfficeService officeService;
		 @RequestMapping(value = "/Manage_Positions", method = RequestMethod.GET)
			public String listPositions(Model model) {
				List<Positions> positions = officeService.getAllPositions();
		        // add the customers to the model
		        model.addAttribute("positions",positions);
				return "managePositions";
			}
		 
		 @RequestMapping(value = "/Accepted_Positions", method = RequestMethod.GET)
			public String listAcceptedPositions(Model model) {
				List<Positions> positions = officeService.getAcceptedPositions();
		        // add the customers to the model
		        model.addAttribute("positions",positions);
				return "acceptedPositions";
			}
		 
		 @RequestMapping(value = "/updateStudentAccess", method = RequestMethod.GET)
		 	public String updateStudentAccess (Model model, @RequestParam String CurrentUpdate) {
			 List<Student> students = studentService.getStudents();
			 model.addAttribute("students", students);
			 System.out.println(CurrentUpdate);
			 int id = Integer.parseInt(CurrentUpdate);
		     studentService.updateStudent(id);
			 
		 	return "redirect:/CareerOffice/list";
		 
		 }
		 
		 @RequestMapping(value = "/updatePositionAccess", method = RequestMethod.GET)
			public String updatePositionAccess(Model model, @RequestParam String CurrentUpdate, @RequestParam String Department  ) {
			 List<Positions> positions = officeService.getAllPositions();
			 model.addAttribute("positions",positions);
			 System.out.println(CurrentUpdate);
			 int id = Integer.parseInt(CurrentUpdate);
			 officeService.updatePositions(id, Department);
				System.out.println(Department);
				return "redirect:/CareerOffice/Manage_Positions";
			}
		 @RequestMapping(value = "/StudentsForInternships", method = RequestMethod.GET)
			public String InternStudents(Model model) {
				List<Positions> positions = officeService.getInternStudents();
		        // add the customers to the model
		        model.addAttribute("positions",positions);
				return "internStudents";
			}

}
