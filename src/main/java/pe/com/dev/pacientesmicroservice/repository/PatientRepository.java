package pe.com.dev.pacientesmicroservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.dev.pacientesmicroservice.model.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUuid(String uuid);

    Patient findByHistory(String history);

    @Query("SELECT p FROM Patient p WHERE " +
            "(p.uuid = :uuid OR :uuid is null) " +
            "AND (p.history = :history OR :history is null)")
    Page<Patient> findByFilters(String uuid, String history, Pageable pageable);
}
