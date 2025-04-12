package pe.com.dev.pacientesmicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pe.com.dev.pacientesmicroservice.model.domain.Patient;
import pe.com.dev.pacientesmicroservice.model.dto.PatientDto;
import pe.com.dev.pacientesmicroservice.model.filter.PatientFilter;
import pe.com.dev.pacientesmicroservice.service.PatientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/create")
    public Patient createSummerSchool(@RequestBody PatientDto dto) {
        return patientService.save(dto);
    }

    @GetMapping("/{id}")
    public PatientDto getSummerSchoolById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @GetMapping("/api/v1/schools")
    public Page<Patient> getSummerSchools(
            @ModelAttribute PatientFilter filter,
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return patientService.filterPatients(
                filter,
                pageable
        );
    }
}
