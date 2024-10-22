package io.fouad.carrerbackend.candidature;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Education {

    @Id
    @GeneratedValue
    private Long id;
    private String institut;
    private String specialisation;
    private String degre;
    private LocalDate debutPeriode;
    private LocalDate finPeriode;
    private boolean actuellementEnPoste;

    @ManyToOne
    @JoinColumn(name = "candidature_id")
    @JsonIgnore
    private Candidature candidature;
}
