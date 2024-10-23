package io.fouad.carrerbackend.candidature.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Link {

    @Id
    @GeneratedValue
    private Long id;
    private String github;
    private String linkedin;
    private String twitter;
    private String facebook;
}
