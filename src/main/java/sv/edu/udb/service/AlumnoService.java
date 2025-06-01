package sv.edu.udb.service;

import sv.edu.udb.entity.dto.AlumnoDTO;
import java.util.List;

public interface AlumnoService {
    List<AlumnoDTO> getAllAlumnos();
    AlumnoDTO getAlumnoById(Integer id);
    AlumnoDTO createAlumno(AlumnoDTO alumnoDTO);
    AlumnoDTO updateAlumno(Integer id, AlumnoDTO alumnoDTO);
    void deleteAlumno(Integer id);
}