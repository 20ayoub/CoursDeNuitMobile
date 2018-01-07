package pi.com.coursdenuitmobile.entities;


import java.util.ArrayList;
import java.util.List;

public class Professeur extends Utilisateur {


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
