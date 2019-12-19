package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.hua.dit.DAO.PositionsDAO;
import gr.hua.dit.entity.Positions;

@Controller
@RequestMapping("/Student/")
public class StudentController {
	
	@Autowired
	private PositionsDAO positionsDAO;
	
	@RequestMapping(value = "/Internship_Request", method = RequestMethod.GET)
	public String newRequestForInternship(Model model) {
		List<Positions> positions = positionsDAO.getAcceptedPositions();
        // add the customers to the model
        model.addAttribute("positions",positions);
		return "internshipRequest";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	   public String showStudentHomeMenu() {
	      return "studentMenu";
	   }
}
