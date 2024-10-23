package io.fouad.carrerbackend.application;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.fouad.carrerbackend.candidature.model.Candidature;
import io.fouad.carrerbackend.offre.model.Offre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidature_id", nullable = false)
    @JsonIgnore
    private Candidature candidature;

    @ManyToOne
    @JoinColumn(name = "offre_id", nullable = false)
    @JsonIgnore
    private Offre offre;
}
