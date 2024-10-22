package io.fouad.carrerbackend.candidature;

import io.fouad.carrerbackend.application.Application;
import io.fouad.carrerbackend.application.ApplicationRepository;
import io.fouad.carrerbackend.offre.Offre;
import io.fouad.carrerbackend.offre.OffreMapper;
import io.fouad.carrerbackend.offre.OffreRepository;
import io.fouad.carrerbackend.offre.OffreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatureService {

    private final OffreRepository offreRepository;
    private final CandidatureRepository candidatureRepository;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public Candidature createCandidature(CandidatureCreateDTO candidatureCreateDTO) {
        Offre offre =  offreRepository
                .findById(candidatureCreateDTO.offreId())
                .orElseThrow(() -> new IllegalArgumentException("offre not found"));

        Candidature candidature = CandidatureMapper.INSTANCE.candidatureCreateDtoToCandidature(candidatureCreateDTO);
        candidature.getEducations().forEach(education -> education.setCandidature(candidature));
        candidature.getExperiences().forEach(experience -> experience.setCandidature(candidature));
        candidatureRepository.save(candidature);
        Application application = Application.builder()
                .candidature(candidature)
                .offre(offre)
                .build();

        applicationRepository.save(application);
        return candidature;
    }

    public List<CandidatureResponseDTO> getAllCandidatures() {
        return candidatureRepository
                .findAll()
                .stream()
                .map(CandidatureMapper.INSTANCE::candidatureToCandidatureResponseDTO)
                .toList();
    }

    public CandidatureResponseDTO getCandidatureById(Long id) {
        return candidatureRepository
                .findById(id)
                .stream()
                .map(CandidatureMapper.INSTANCE::candidatureToCandidatureResponseDTO)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("candidature not found"));
    }

    public ResponseEntity<Void> deleteCandidature(Long id) {
        Candidature candidature = candidatureRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("candidature not found"));
        candidatureRepository.delete(candidature);
        return ResponseEntity.noContent().build();
    }


}
