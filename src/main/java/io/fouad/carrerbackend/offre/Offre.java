package io.fouad.carrerbackend.offre;

import io.fouad.carrerbackend.candidature.Addresse;
import io.fouad.carrerbackend.candidature.Candidature;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Offre {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private WorkMode workMode;
    private String description;
    private int experience;
    @ElementCollection
    private List<String> missions;
    @ElementCollection
    private List<String> savoirFaires;
    @ElementCollection
    private List<String> savoirEtres;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Addresse addresse;

    @ManyToMany
    private Set<Candidature> candidatures = new HashSet<>();
}
