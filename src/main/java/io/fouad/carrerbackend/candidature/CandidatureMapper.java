package io.fouad.carrerbackend.candidature;



import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CandidatureMapper {

    CandidatureMapper INSTANCE = Mappers.getMapper(CandidatureMapper.class);

    Candidature candidatureCreateDtoToCandidature(CandidatureCreateDTO candidatureCreateDTO);

    CandidatureResponseDTO candidatureToCandidatureResponseDTO(Candidature candidature);
}
