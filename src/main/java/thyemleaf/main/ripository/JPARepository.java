package thyemleaf.main.ripository;

import org.springframework.data.jpa.repository.JpaRepository;

import thyemleaf.main.entities.Student;


public interface JPARepository extends JpaRepository<Student,Long> {
	Student findByEmail(String email);
	
}
