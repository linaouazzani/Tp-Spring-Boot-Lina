package pharmacie.entity;

import java.math.BigDecimal;
import java.time.LocalDate; // Import manquant ajouté
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; // Préférable pour initialiser la liste
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer numero;

    @NonNull
    @NotNull
    private LocalDate saisieLe;

    private LocalDate envoyeeLe;

    @PositiveOrZero
    private BigDecimal port = BigDecimal.ZERO;

    @NonNull
    @NotBlank // Assure que le nom du destinataire n'est pas vide
    private String destinataire;

    @PositiveOrZero
    private BigDecimal remise = BigDecimal.ZERO;

    @ManyToOne(optional = false)
    @NonNull
    @NotNull
    private Dispensaire dispensaire;

    @ManyToOne(cascade = CascadeType.ALL) // Selon le schéma logique, plusieurs commandes peuvent partager une adresse
    private AdressePostale adresseLivraison;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Ligne> lignes = new ArrayList<>();
}