package sv.edu.udb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.entity.dto.AlumnoDTO;
import sv.edu.udb.service.AlumnoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/alumnos")
public class AlumnoController {
    private final AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> getAllAlumnos() {
        return ResponseEntity.ok(alumnoService.getAllAlumnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> getAlumnoById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(alumnoService.getAlumnoById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AlumnoDTO> createAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        try {
            return ResponseEntity.ok(alumnoService.createAlumno(alumnoDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> updateAlumno(@PathVariable Integer id, @RequestBody AlumnoDTO alumnoDTO) {
        try {
            return ResponseEntity.ok(alumnoService.updateAlumno(id, alumnoDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Integer id) {
        try {
            alumnoService.deleteAlumno(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
