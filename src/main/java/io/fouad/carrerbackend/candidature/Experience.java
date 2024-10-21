package io.fouad.carrerbackend.candidature;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Experience {

    @Id
    @GeneratedValue
    private Long id;
    private String profession;
    private String societe;
    private String description;
    private LocalDate debutPeriode;
    private LocalDate finPeriode;
    private boolean actuellementEnPoste;
}
