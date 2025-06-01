package sv.edu.udb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.entity.dto.MateriaDTO;
import sv.edu.udb.service.MateriaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/materias")
public class MateriaController {
    private final MateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<MateriaDTO>> getAllMaterias() {
        return ResponseEntity.ok(materiaService.getAllMaterias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> getMateriaById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(materiaService.getMateriaById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MateriaDTO> createMateria(@RequestBody MateriaDTO materiaDTO) {
        try {
            return ResponseEntity.ok(materiaService.createMateria(materiaDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaDTO> updateMateria(@PathVariable Integer id, @RequestBody MateriaDTO materiaDTO) {
        try {
            return ResponseEntity.ok(materiaService.updateMateria(id, materiaDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable Integer id) {
        try {
            materiaService.deleteMateria(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
