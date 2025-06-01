package sv.edu.udb.service;

import sv.edu.udb.entity.dto.MateriaDTO;

import java.util.List;

public interface MateriaService {
    List<MateriaDTO> getAllMaterias();
    MateriaDTO getMateriaById(Integer id);
    MateriaDTO createMateria(MateriaDTO materiaDTO);
    MateriaDTO updateMateria(Integer id, MateriaDTO materiaDTO);
    void deleteMateria(Integer id);
}
