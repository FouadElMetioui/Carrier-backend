package io.fouad.carrerbackend.offre;

import io.fouad.carrerbackend.offre.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreRepository extends JpaRepository<Offre, Long> {

}
