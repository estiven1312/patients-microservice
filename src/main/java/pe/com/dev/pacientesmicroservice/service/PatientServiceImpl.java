package pe.com.dev.pacientesmicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.dev.pacientesmicroservice.model.domain.Patient;
import pe.com.dev.pacientesmicroservice.model.dto.PatientDto;
import pe.com.dev.pacientesmicroservice.model.filter.PatientFilter;
import pe.com.dev.pacientesmicroservice.model.mapper.PatientMapper;
import pe.com.dev.pacientesmicroservice.repository.PatientRepository;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Page<Patient> filterPatients(PatientFilter filter, Pageable pageable) {
        // Implement the logic to filter patients based on the provided filter and pageable parameters
        return patientRepository.findByFilters(
                filter.getUuid(),
                filter.getHistory(),
                pageable
        );
    }

    @Override
    public PatientDto findById(Long id) {
        // Implement the logic to find a patient by ID
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        PatientDto patientDto = PatientMapper.INSTANCE.toDto(patient);
        return patientDto;
    }

    @Override
    public Patient save(PatientDto patient) {
        // Implement the logic to save a patient
        Patient patientEntity = PatientMapper.INSTANCE.toEntity(patient);
        patientEntity = patientRepository.save(patientEntity);
        return patientEntity;
    }
}
