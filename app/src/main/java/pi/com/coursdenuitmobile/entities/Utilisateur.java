package pi.com.coursdenuitmobile.entities;


import pi.com.coursdenuitmobile.enume.Genre;

public abstract class Utilisateur {


	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String motDepasse;
	private Genre genre;
	private boolean isAdmin=false;
	private Byte[] Image;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom, String email, String motDepasse, Genre genre) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDepasse = motDepasse;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte[] getImage() {
		return Image;
	}

	public void setImage(Byte[] image) {
		Image = image;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDepasse() {
		return motDepasse;
	}

	public void setMotDepasse(String motDepasse) {
		this.motDepasse = motDepasse;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
