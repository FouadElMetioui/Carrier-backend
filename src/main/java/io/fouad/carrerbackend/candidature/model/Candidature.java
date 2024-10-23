package io.fouad.carrerbackend.candidature.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.fouad.carrerbackend.application.Application;
import io.fouad.carrerbackend.fichier.Ficher;
import io.fouad.carrerbackend.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Education> educations;

    @OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Experience> experiences;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "infoProfessionnel_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private InfoProfessionnel infoProfessionnel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "link_id", referencedColumnName = "id")
    private Link link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fichier_id", referencedColumnName = "id")
    private Ficher fichier;

    @OneToMany(mappedBy = "candidature",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Application> applications;




}
