package io.fouad.carrerbackend.candidature;

import io.fouad.carrerbackend.application.Application;
import io.fouad.carrerbackend.fichier.Ficher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Education> educations;

    @OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Experience> experiences;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "infoProfessionnel_id", referencedColumnName = "id")
    private InfoProfessionnel infoProfessionnel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "link_id", referencedColumnName = "id")
    private Link link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fichier_id", referencedColumnName = "id")
    private Ficher fichier;

    @OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Application> applications;




}
