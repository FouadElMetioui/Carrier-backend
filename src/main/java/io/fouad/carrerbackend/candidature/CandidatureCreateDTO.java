package io.fouad.carrerbackend.candidature;

import io.fouad.carrerbackend.fichier.Ficher;
import jakarta.persistence.*;

import java.util.List;

public record CandidatureCreateDTO(
         String civilite,
         String prenom,
         String nom,
         String numero,
         Addresse addresse,
         List<Education> educations,
         List<Experience> experiences,
         InfoProfessionnel infoProfessionnel,
         Link link,
         Ficher fichier ,
         Long offreId
) {
}
