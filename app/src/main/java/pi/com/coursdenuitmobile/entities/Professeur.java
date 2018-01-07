package pi.com.coursdenuitmobile.entities;


import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Professeur extends Utilisateur {

	@JsonIgnore
    private List<Requete> offres;


    public Professeur() {
        offres = new ArrayList<Requete>();
    }

    public List<Requete> getOffres() {
        return offres;
    }

    public void setOffres(List<Requete> offres) {
        this.offres = offres;
    }


}
