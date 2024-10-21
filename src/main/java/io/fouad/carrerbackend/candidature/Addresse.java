package io.fouad.carrerbackend.candidature;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Addresse {

    @Id
    @GeneratedValue
    private Long id;
    private String pays;
    private String ville;
    private String province;
    private int codePostal;
    private String rue;


}
