package pharmacie.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter @Setter @NoArgsConstructor @ToString
public class AdressePostale{
    @NotBlank
    private String codePostal;

    @NotBlank
    private String ville;

    @NotBlank
    private String region;

    @NotBlank
    private String adresse;

    @NotBlank
    private String pays;
}