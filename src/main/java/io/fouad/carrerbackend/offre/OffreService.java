package io.fouad.carrerbackend.offre;

import io.fouad.carrerbackend.application.Application;
import io.fouad.carrerbackend.application.ApplicationRepository;
import io.fouad.carrerbackend.candidature.model.Candidature;
import io.fouad.carrerbackend.offre.dto.OffreCreateDTO;
import io.fouad.carrerbackend.offre.dto.OffreMapper;
import io.fouad.carrerbackend.offre.dto.OffreResponseDTO;
import io.fouad.carrerbackend.offre.model.Offre;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OffreService {

    private final OffreRepository offreRepository;
    private final ApplicationRepository applicationRepository;

    public Offre createOffre(OffreCreateDTO offreCreateDTO) {
        return offreRepository.save(OffreMapper.INSTANCE.offreCreateDtoToOffre(offreCreateDTO));
    }

    public List<OffreResponseDTO> getAllOffres() {
        return offreRepository
                .findAll()
                .stream()
                .map(OffreMapper.INSTANCE::offreToOffreResponseDTO)
                .toList();
    }

    public OffreResponseDTO getOffreById(Long id) {
        return offreRepository
                .findById(id)
                .stream()
                .map(OffreMapper.INSTANCE::offreToOffreResponseDTO)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("offre not found"));
    }

    public ResponseEntity<Void> deleteOffre(Long id) {
        Offre offre = offreRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("offre not found"));
        offreRepository.delete(offre);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public Offre updateOffre(Long id , OffreCreateDTO offreCreateDTO) {
        Offre offre = offreRepository
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

    public List<Candidature> getCandidaturesOffre(Long offreId) {
       offreRepository.findById(offreId).orElseThrow(() -> new IllegalArgumentException("offre not found with id = " + offreId));
       List<Application> applications = applicationRepository.findByOffreId(offreId);

        return applications
                .stream()
                .map(Application::getCandidature)
                .toList();


    }
}
