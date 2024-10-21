package io.fouad.carrerbackend.candidature;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InfoProfessionnel {

    @Id
    @GeneratedValue
    private Long id;
    private String fonctionActuelle;
    @ElementCollection
    private Set<String> competences;
}
