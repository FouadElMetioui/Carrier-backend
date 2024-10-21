package io.fouad.carrerbackend.offre;

import io.fouad.carrerbackend.candidature.Addresse;
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
