package gr.hua.dit.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Positions;
import gr.hua.dit.entity.Student;
import gr.hua.dit.service.CompanyService;
import gr.hua.dit.service.StudentService;

@RestController
@RequestMapping("/api")
public class CompanyRestController {
		
		@Autowired
		private StudentService studentService;
		@Autowired
		private CompanyService companyService;
		
		
		@GetMapping("/students")
        public List<Student> getStudents() {
                List<Student> students = studentService.getStudents();
                return students;

        }
		
		@PostMapping("/addposition")
		public Positions addPositions(@RequestParam("compName") String compName,
                @RequestParam("category") String category) {
			Positions thePosition = new Positions(compName, category , false , null);
//			thePosition.setName(compName);
//			thePosition.setCategory(category);
			System.out.println(thePosition);
			companyService.saveCompanyPosition(compName,category);
			return thePosition;
			
		}
		
		@GetMapping("/positions")
		public List<Positions> seePositions(@RequestParam("compName") String compName){
			List<Positions> positions = companyService.copmanyPositions(compName);
			
			return positions;
		}
		
		@GetMapping("/studentsForposition")
		public List<Student> StudentsForPosition(@RequestParam("compName") String compName,@RequestParam("posID") int posID){
			List<Student> students = companyService.StudentsForPosition(compName,posID);
			
			return students;
		}
		
		
}
