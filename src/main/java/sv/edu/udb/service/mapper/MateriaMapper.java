package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sv.edu.udb.entity.dto.MateriaDTO;
import sv.edu.udb.entity.Materia;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MateriaMapper {
    MateriaMapper INSTANCE = Mappers.getMapper(MateriaMapper.class);
    MateriaDTO toMateriaDTO(Materia materia);
    Materia toMateria(MateriaDTO materiaDTO);
}
