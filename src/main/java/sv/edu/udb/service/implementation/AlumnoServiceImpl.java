package sv.edu.udb.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.entity.dto.AlumnoDTO;
import sv.edu.udb.entity.Alumno;
import sv.edu.udb.repository.AlumnoRepository;
import sv.edu.udb.service.AlumnoService;
import sv.edu.udb.service.mapper.AlumnoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }

    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        return alumnoRepository.findAll()
                .stream()
                .map(alumnoMapper::toAlumnoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlumnoDTO getAlumnoById(Integer id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró al alumno"));
        return alumnoMapper.toAlumnoDTO(alumno);
    }

    @Override
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
        Alumno saved = alumnoRepository.save(alumno);
        return alumnoMapper.toAlumnoDTO(saved);
    }

    @Override
    public AlumnoDTO updateAlumno(Integer id, AlumnoDTO alumnoDTO) {
        Alumno existing = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró al alumno"));
        existing.setNombre(alumnoDTO.getNombre());
        existing.setApellido(alumnoDTO.getApellido());
        existing.setMateria(alumnoMapper.toAlumno(alumnoDTO).getMateria());
        Alumno updated = alumnoRepository.save(existing);
        return alumnoMapper.toAlumnoDTO(updated);
    }

    @Override
    public void deleteAlumno(Integer id) {
        Alumno existing = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró al alumno"));
        alumnoRepository.delete(existing);
    }
}
