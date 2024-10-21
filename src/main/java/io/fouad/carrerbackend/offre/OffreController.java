package io.fouad.carrerbackend.offre;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/offres")
@ApiResponse(description = "manipuler les offres")
@RequiredArgsConstructor
public class OffreController {

    public final OffreService offreService;

    @Operation(summary = "trouver tous les offres ",
            description = "return un tableau des offres")
    @GetMapping
    public ResponseEntity<List<OffreResponseDTO>> getAllOffres() {
        return ResponseEntity.ok(offreService.getAllOffres());
    }

    @Operation(summary = "ajouter un offre",
            description = "ajouter un offres avec tout ces attributs inclus: addresse,experience..")
    @PostMapping
    public ResponseEntity<Offre> createOffre(@RequestBody OffreCreateDTO offreCreateDTO) {
        System.out.println(offreCreateDTO);
        return ResponseEntity.ok(offreService.createOffre(offreCreateDTO));
    }

    @Operation(summary = "Trouver une offre par ID",
            description = "Récupère une offre à partir de son ID unique.")
    @GetMapping("{id}")
    public ResponseEntity<OffreResponseDTO> getOffreById(@PathVariable Long id) {;
        return ResponseEntity.ok(offreService.getOffreById(id));
    }

    @Operation(summary = "Supprimer une offre par ID",
            description = "Récupère une offre à partir de son ID unique.")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOffreById(@PathVariable Long id) {
        return offreService.deleteOffre(id);
    }

}
