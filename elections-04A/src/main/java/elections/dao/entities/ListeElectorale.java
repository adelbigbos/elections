package elections.dao.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ListeElectorale  {

	/**
	* identit� de la liste
	*/
	@Autowired
	@Qualifier
	 private int id;
	 /**
	  * nom de la classe.
	  */
	@Autowired
	@Qualifier
	 private String nom;	
	 /**
	  * nombre de voix de la liste.
	  */
	@Autowired
	@Qualifier
	 private int voix;	
	 /**
	  * nombre de sieges de la liste.
	  */
	@Autowired
	@Qualifier
	 private int sieges;
	 /**
	  * indique si la liste est �limin� ou non.
	  */
	@Autowired
	@Qualifier
	 private boolean elimine;
	 /**
	  * num�ro de liste courant.
	  */
	@Autowired
	@Qualifier 
	private static int numListeCourant=0;
	 
	 // Constructeur par defaut.
	public ListeElectorale() {
		this("inconnu", 0, 0, false);	
	
		
	}
	/**
	*
	* @param nom String : le nom de la liste
	* @param voix int : son nombre de voix
	* @param sieges int : son nombre de sieges
	* @param elimine boolean : son �tat �limin� ou non
	*/

	public ListeElectorale(int id ,String nom, int voix, int sieges, boolean elimine) {
		super();
		
		setId(id);
		setNom(nom);
		setVoix(voix);
		setSieges(sieges);
		setElimine(elimine);
	}
	/**
	 * @param id : l 'id est g�rer automatiquement, il est incr�ment� � chaque cr�ation d'une liste.
	 * @param nom : le nom de la liste	
	 * @param voix : son nombre de voix
	 * @param sieges: son nombre de si�ges
	 * @param elimine :son �tat �limin� ou non.
	 */
	public ListeElectorale(String nom, int voix, int sieges, boolean elimine){
		super();
	
		this.id=++numListeCourant;
		setNom(nom);
		setVoix(voix);
		setSieges(sieges);
		setElimine(elimine);
		
	}
		
	/**
	*
	* @return int : l'identifiant de la liste
	*/
	
	public int getId() {
		return id;
	}
	
	/**
	 * initialise l'identifiant de liste
	 * @param id int : identifiant de la liste
	 * @throws ElectionsException si id<1
	 */
	
	public void setId(int id) throws ElectionsException{
		if(id<1){
			throw new ElectionsException();
		}
		this.id = id;
	}
	/**
	*
	* @return String : le nom de la liste
	*/
	public String getNom() {
		return nom;
	}
	/**
	* initialise le nom de la liste
	* @param nom String : nom de la liste
	* @throws ElectionsException si le nom est vide ou blanc.
	*/
	
	public void setNom(String nom) throws ElectionsException{
		if(nom.length()==0 ||nom.equals("")){
			throw new ElectionsException(100, "Erreur : Veuillez inserez un nom !");
		}
		this.nom = nom;
	}
	
	/**
	*
	* @return int : le nombre de voix de la liste
	*/
	public int getVoix() {
		return voix;
	}
	
	/**
	* initialise le nombre de voix de la liste
	* @param voix int : le nombre de voix de la liste
	* @throws ElectionsException si le nombre de voix <0.
	*/
	
	public void setVoix(int voix) throws ElectionsException{
		if (voix <0){
			throw new ElectionsException(101, "Erreur : le nombre de voix ne peux �tre n�gatif");
		}
		this.voix = voix;
	}
	
	/**
	*
	* @return int : le nombre de si�ges de la liste
	*/
	
	public int getSieges() {
		return sieges;
	}
	
	/**
	* fixe le nombre de si�ges de la liste
	* @param sieges int : le nombre de si�ges de la liste
	* @throws ElectionsException si le nombre de si�ges <0.
	*/
	
	public void setSieges(int sieges) throws ElectionsException{
		if(sieges <0){
			throw new ElectionsException(102, "Erreur: le nombre de si�ges ne peut �tre inf�rieur � z�ro.");
		}
		this.sieges = sieges;
	}
	
	/**
	*
	* @return boolean : valeur du champ elimine
	*/
	public boolean isElimine() {
		return elimine;
	}
	
	/**
	*
	* @param sieges int
	*/
	
	public void setElimine(boolean elimine) {
		this.elimine = elimine;
	}

	/**
	*
	* @return String : identit� de la liste �lectorale
	*/
	public String toString() {
		return "[" + id + "," + nom + "," + voix + "," + sieges + ","
				+ elimine + "]";
	}
	
	
	
	
	
	

}
