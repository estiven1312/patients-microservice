package pe.com.dev.pacientesmicroservice.model.filter;

import lombok.Data;

@Data
public class PatientFilter {
    private String uuid;
    private String history;
}
