package sv.edu.udb.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.entity.dto.MateriaDTO;
import sv.edu.udb.entity.Materia;
import sv.edu.udb.repository.MateriaRepository;
import sv.edu.udb.service.MateriaService;
import sv.edu.udb.service.mapper.MateriaMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MateriaServiceImpl implements MateriaService {
    private final MateriaRepository materiaRepository;
    private final MateriaMapper materiaMapper;

    public MateriaServiceImpl(MateriaRepository materiaRepository, MateriaMapper materiaMapper) {
        this.materiaRepository = materiaRepository;
        this.materiaMapper = materiaMapper;
    }

    @Override
    public List<MateriaDTO> getAllMaterias() {
        return materiaRepository.findAll()
                .stream()
                .map(materiaMapper::toMateriaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MateriaDTO getMateriaById(Integer id) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la materia"));
        return materiaMapper.toMateriaDTO(materia);
    }

    @Override
    public MateriaDTO createMateria(MateriaDTO materiaDTO) {
        Materia materia = materiaMapper.toMateria(materiaDTO);
        Materia saved = materiaRepository.save(materia);
        return materiaMapper.toMateriaDTO(saved);
    }

    @Override
    public MateriaDTO updateMateria(Integer id, MateriaDTO materiaDTO) {
        Materia existing = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la materia"));
        existing.setNombre(materiaDTO.getNombre());
        Materia updated = materiaRepository.save(existing);
        return materiaMapper.toMateriaDTO(updated);
    }

    @Override
    public void deleteMateria(Integer id) {
        Materia existing = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la materia"));
        materiaRepository.delete(existing);
    }
}
