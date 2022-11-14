package tn.esprit.rh.achat.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategorieProduitDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorieProduit;
	
	
	/**
	 * 
	 */
	private String libelleCategorie;
	@OneToMany(mappedBy = "categorieProduit")
	@JsonIgnore
	private Set<Produit> produits;
	private String codeCategorie;
}