package io.fouad.carrerbackend.offre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OffreMapper {
    OffreMapper INSTANCE = Mappers.getMapper(OffreMapper.class);

    Offre offreCreateDtoToOffre(OffreCreateDTO offreCreateDTO);

    OffreResponseDTO offreToOffreResponseDTO(Offre offre);
}
