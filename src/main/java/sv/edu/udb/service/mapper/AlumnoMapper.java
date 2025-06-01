package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sv.edu.udb.entity.dto.AlumnoDTO;
import sv.edu.udb.entity.Alumno;

import java.util.List;

@Mapper(componentModel = "spring", uses = { MateriaMapper.class })
public interface AlumnoMapper {
    AlumnoMapper INSTANCE = Mappers.getMapper(AlumnoMapper.class);
    AlumnoDTO toAlumnoDTO(Alumno alumno);
    Alumno toAlumno(AlumnoDTO alumnoDTO);
}
