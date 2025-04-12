package pe.com.dev.pacientesmicroservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.com.dev.pacientesmicroservice.model.domain.Patient;
import pe.com.dev.pacientesmicroservice.model.dto.PatientDto;
import pe.com.dev.pacientesmicroservice.model.filter.PatientFilter;

public interface PatientService {
    Page<Patient> filterPatients(PatientFilter filter, Pageable pageable);
    PatientDto findById(Long id);
    Patient save(PatientDto patient);
}
