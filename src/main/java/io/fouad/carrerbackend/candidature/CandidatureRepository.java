package io.fouad.carrerbackend.candidature;

import io.fouad.carrerbackend.candidature.model.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

}
