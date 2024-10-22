package io.fouad.carrerbackend.application;

import io.fouad.carrerbackend.candidature.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByOffreId(Long id);

}
