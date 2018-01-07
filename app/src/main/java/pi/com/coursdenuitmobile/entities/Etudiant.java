package pi.com.coursdenuitmobile.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bnn on 07/01/2018.
 */

public class Etudiant extends Utilisateur {
    private List<Requete> demandes;

    public List<Requete> getDemandes() {
        return demandes;
    }

    public Etudiant() {
        super();
        this.demandes = new ArrayList<Requete>();
    }

    public void setDemandes(List<Requete> demandes) {
        this.demandes = demandes;
    }

}
