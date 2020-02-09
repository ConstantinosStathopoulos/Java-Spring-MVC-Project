package gr.hua.dit.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		
//		@PostMapping(value = "/addposition")
//		public Positions addPositions(@RequestParam("compName") String compName,
//            @RequestParam("category") String category) {
//			Positions thePosition = new Positions(compName, category , false , null);
////			thePosition.setName(compName);
////			thePosition.setCategory(category);
//			System.out.println(thePosition);
//			companyService.saveCompanyPosition(compName,category);
//			return thePosition;
//			
//		}
		
		
		
		@PostMapping(value = "/addposition",  produces = { "application/json", "application/xml" })
		public Positions addPositions(@RequestParam("compName") String compName,
            @RequestParam("category") String category) {
			Positions thePosition = new Positions(compName, category , false , null);
			System.out.println(thePosition);
			companyService.saveCompanyPosition(compName,category);
			return thePosition;
			
		}
	
	  //@GetMapping("/positions") public List<Positions>
		@CrossOrigin
		@RequestMapping(value = "/positions", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
		public List<Positions> seePositions(@RequestParam("compName") String compName){ 
			
			
			List<Positions> positions = companyService.companyPositions(compName);
			System.out.println(positions);
		
		return positions; 
		
		
		}
//		@CrossOrigin
//		@RequestMapping(value = "/positions", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
//		public String seePositions(@RequestParam("compName") String compName){
//			List<Positions> positions = companyService.companyPositions(compName);
//			//testing
//			System.out.println(positions);
//			Object[] obj = positions.toArray();
//			System.out.println(obj);
//			//positions
//			return convertPositionToJsonP(obj);
//		}
//		
//		private String convertPositionToJsonP(Object[] obj) {
//			
//			ObjectMapper mapper = new ObjectMapper();
//		    String arrayToJson=null;
//			try {
//				arrayToJson = mapper.writeValueAsString(obj);
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("Convert List to JSON :");
//		    System.out.println(arrayToJson);
//			return arrayToJson;
//		}
		
		@CrossOrigin
		@RequestMapping(value = "/studentsForposition", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
		public List<Student> StudentsForPosition(@RequestParam("compName") String compName,@RequestParam("posID") int posID){
			List<Student> students = companyService.StudentsForPosition(compName,posID);
			
			return students;
		}
		
		
}
