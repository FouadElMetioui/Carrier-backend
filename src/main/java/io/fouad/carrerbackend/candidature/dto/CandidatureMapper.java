package io.fouad.carrerbackend.candidature.dto;



import io.fouad.carrerbackend.candidature.model.Candidature;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CandidatureMapper {

    CandidatureMapper INSTANCE = Mappers.getMapper(CandidatureMapper.class);

    Candidature candidatureCreateDtoToCandidature(CandidatureCreateDTO candidatureCreateDTO);

    CandidatureResponseDTO candidatureToCandidatureResponseDTO(Candidature candidature);
}
