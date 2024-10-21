package io.fouad.carrerbackend.fichier;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ficher {

    @Id
    @GeneratedValue
    private Long id;
    private String cvUrl;
    private String lettreMotivationUrl;
}
