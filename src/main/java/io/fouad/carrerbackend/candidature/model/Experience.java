package io.fouad.carrerbackend.candidature.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.fouad.carrerbackend.candidature.model.Candidature;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "candidature_id")
    @JsonIgnore
    private Candidature candidature;
}
