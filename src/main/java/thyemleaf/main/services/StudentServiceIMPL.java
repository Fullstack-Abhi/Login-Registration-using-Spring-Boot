package thyemleaf.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thyemleaf.main.entities.Student;
import thyemleaf.main.ripository.JPARepository;

@Service
public class StudentServiceIMPL implements StudentService {
		
		@Autowired
		private JPARepository jpaconfiguration;
	
	@Override
	public boolean addDetails(Student student) {
		
		
		try {
			jpaconfiguration.save(student);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Student loginstudent(String email, String password) {
		
		Student validstudent= jpaconfiguration.findByEmail(email);
		
		if(validstudent!=null && validstudent.getPassword().equals(password)) {
			return validstudent;
		}
		else {
			return null;
		}
	}
	
}
