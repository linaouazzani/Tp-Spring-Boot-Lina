package pharmacie.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Dispensaire {
    @Id
    @NonNull @NotBlank
    @Column(length = 5)
    private String code;

    @NonNull @NotBlank
    private String nom;

    private String contact;
    private String fonction;
    private String telephone;
    private String fax;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id")
    private AdressePostale adresse;

    @OneToMany(mappedBy = "dispensaire")
    @ToString.Exclude
    private List<Commande> commandes;
}