package pe.com.dev.pacientesmicroservice.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.com.dev.pacientesmicroservice.model.domain.Patient;
import pe.com.dev.pacientesmicroservice.model.dto.PatientDto;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    PatientDto toDto(Patient patient);
    Patient toEntity(PatientDto patientDto);
}
