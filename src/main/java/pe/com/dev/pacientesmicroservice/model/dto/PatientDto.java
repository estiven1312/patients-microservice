package pe.com.dev.pacientesmicroservice.model.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class PatientDto {
    private Long id;
    private String uuid;
    private String history;
    private LocalDateTime birthDate;
    private String sex;
    private Long age;
    private String address;
    private Long attentionNumber;
    private LocalDateTime registerDate;
}
