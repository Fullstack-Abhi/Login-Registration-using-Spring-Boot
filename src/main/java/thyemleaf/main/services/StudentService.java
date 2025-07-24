package thyemleaf.main.services;

import thyemleaf.main.entities.Student;

public interface StudentService {
	
	public boolean addDetails(Student student);
	public Student loginstudent(String email,String password); 
}
