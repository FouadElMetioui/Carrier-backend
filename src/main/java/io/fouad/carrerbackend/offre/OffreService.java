package io.fouad.carrerbackend.offre;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OffreService {

    private final OffreRepository repository;

    public Offre createOffre(OffreCreateDTO offreCreateDTO) {
        return repository.save(OffreMapper.INSTANCE.offreCreateDtoToOffre(offreCreateDTO));
    }

    public List<OffreResponseDTO> getAllOffres() {
        return repository
                .findAll()
                .stream()
                .map(OffreMapper.INSTANCE::offreToOffreResponseDTO)
                .toList();
    }

    public OffreResponseDTO getOffreById(Long id) {
        return repository
                .findById(id)
                .stream()
                .map(OffreMapper.INSTANCE::offreToOffreResponseDTO)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("offre not found"));
    }

    public ResponseEntity<Void> deleteOffre(Long id) {
        Offre offre = repository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("offre not found"));
        repository.delete(offre);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public Offre updateOffre(Long id , OffreCreateDTO offreCreateDTO) {
        Offre offre = repository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("offre not found to update"));

        offre.setWorkMode(offreCreateDTO.workMode());
        offre.setAddresse(offreCreateDTO.addresse());
        offre.setDescription(offreCreateDTO.description());
        offre.setMissions(offreCreateDTO.missions());
        offre.setExperience(offreCreateDTO.experience());
        offre.setSavoirEtres(offreCreateDTO.savoirEtres());
        offre.setSavoirFaires(offreCreateDTO.savoirFaires());

        return offre;
    }
}
