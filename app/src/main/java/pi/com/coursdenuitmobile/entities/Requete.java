package pi.com.coursdenuitmobile.entities;


import pi.com.coursdenuitmobile.enume.EtatRequete;

public class Requete {


	private Utilisateur createur;
	private Utilisateur destination;

	public Requete(Utilisateur createur, Utilisateur destinataire) {
		super();
		this.createur = createur;
		this.destination = destinataire;
	}

	public Requete() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateur getExpediteur() {
		return createur;
	}

	public void setExpediteur(Utilisateur expediteur) {
		createur = expediteur;
	}

	public Utilisateur getDestinataire() {
		return destination;
	}

	public void setDestinataire(Utilisateur destinataire) {
		this.destination = destinataire;
	}


	private Long id;


	private EtatRequete etat = EtatRequete.En_Cours;;

	public Long getId() {
		return id;
	}

	public EtatRequete getEtat() {
		return etat;
	}

	public void setEtat(EtatRequete etat) {
		this.etat = etat;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
