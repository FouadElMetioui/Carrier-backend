package io.fouad.carrerbackend.offre;

import io.fouad.carrerbackend.application.Application;
import io.fouad.carrerbackend.candidature.Addresse;
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
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Addresse addresse;
    @OneToMany(mappedBy = "offre", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Application> applications;
}
