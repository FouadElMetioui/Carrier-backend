package io.fouad.carrerbackend.candidature;

import io.fouad.carrerbackend.fichier.Ficher;
import io.fouad.carrerbackend.offre.Offre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candidature {

    @Id
    @GeneratedValue
    private Long id;
    private String civilite;
    private String prenom;
    private String nom;
    private String numero;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Addresse addresse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    private Education education;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_id", referencedColumnName = "id")
    private Experience experience;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "infoProfessionnel_id", referencedColumnName = "id")
    private InfoProfessionnel infoProfessionnel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "link_id", referencedColumnName = "id")
    private Link link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fichier_id", referencedColumnName = "id")
    private Ficher fichier;

    @ManyToMany
    @JoinTable(
            name = "candidature_offre",
            joinColumns = @JoinColumn(name = "candidature_id"),
            inverseJoinColumns = @JoinColumn(name = "offre_id")
    )
    private Set<Offre> offres = new HashSet<>();



}
