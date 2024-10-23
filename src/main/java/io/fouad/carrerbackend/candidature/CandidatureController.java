package io.fouad.carrerbackend.candidature;

import io.fouad.carrerbackend.candidature.dto.CandidatureCreateDTO;
import io.fouad.carrerbackend.candidature.dto.CandidatureResponseDTO;
import io.fouad.carrerbackend.candidature.model.Candidature;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidatures")
@ApiResponse(description = "manipuler les candidatures")
@RequiredArgsConstructor
public class CandidatureController {

    public final CandidatureService candidatureService;

    @Operation(summary = "trouver tous les candidature ",
            description = "return un tableau des candidature")
    @GetMapping
    public ResponseEntity<List<CandidatureResponseDTO>> getAllCandidatures() {
        return ResponseEntity.ok(candidatureService.getAllCandidatures());
    }

    @Operation(summary = "ajouter un candidature",
            description = "ajouter un candidature avec tout ces attributs inclus: addresse,experience..")
    @PostMapping
    public ResponseEntity<Candidature> createCandidature(@RequestBody CandidatureCreateDTO candidatureCreateDTO) {
        System.out.println(candidatureCreateDTO);
        return ResponseEntity.ok(candidatureService.createCandidature(candidatureCreateDTO));
    }

    @Operation(summary = "Trouver une candidature par ID",
            description = "Récupèrer une candidature à partir de son ID unique.")
    @GetMapping("{id}")
    public ResponseEntity<CandidatureResponseDTO> getCandidatureById(@PathVariable Long id) {
        return ResponseEntity.ok(candidatureService.getCandidatureById(id));
    }

    @Operation(summary = "Supprimer une candidature par ID",
            description = "Récupère une candidature à partir de son ID unique.")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCandidatureById(@PathVariable Long id) {
        return candidatureService.deleteCandidature(id);
    }
}
