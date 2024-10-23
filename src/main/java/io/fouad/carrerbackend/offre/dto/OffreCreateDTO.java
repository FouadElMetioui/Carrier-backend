package io.fouad.carrerbackend.offre.dto;

import io.fouad.carrerbackend.candidature.model.Addresse;
import io.fouad.carrerbackend.offre.WorkMode;

import java.util.List;

public record OffreCreateDTO(
         WorkMode workMode,
         String description,
         int experience,
         List<String>missions,
         List<String> savoirFaires,
         List<String> savoirEtres,
         Addresse addresse
) {
}
