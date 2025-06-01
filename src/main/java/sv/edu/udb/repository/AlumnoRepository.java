package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.udb.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}
