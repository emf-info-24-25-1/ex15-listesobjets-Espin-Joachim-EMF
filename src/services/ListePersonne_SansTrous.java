package services;

import models.Personne;

public class ListePersonne_SansTrous {

    public final static int NBRE_MAX_PERSONNES = 6;

    private Personne[] personnes;
    private int nbPersonnes;

    public ListePersonne_SansTrous(){
       this.personnes = new Personne[NBRE_MAX_PERSONNES] ;
       this.nbPersonnes = 0;
    }

    public int getNombre() {
        return nbPersonnes;
    }

    public void vider() {
        for (int i = 0; i < personnes.length; i++) {
            if (personnes[i] != null) {
                personnes[i] = null;
                nbPersonnes--;
            }
        }
    }

    public boolean ajouter(Personne p) {
        boolean ajoutReussi = false;
        for (int i = 0; i < personnes.length; i++) {
            if (personnes[i] == null) {
                personnes[i] = p;
                ajoutReussi = true;
                nbPersonnes++;
                break;
            }
            else {
                ajoutReussi = false;
            }
        }
        return ajoutReussi;
    }

    public boolean supprimer(Personne p) {
        Boolean supprimerPersonne = false;
        for (int i = 0; i < personnes.length; i++) {
            if (personnes[i] == p) {
                personnes[i] = null;
                nbPersonnes--;
                for (int j = i; j < personnes.length - 1; j++) {
                    personnes[j] = personnes[j + 1];
                }
                personnes[personnes.length - 1] = null;
                supprimerPersonne = true;
                break;
            }

        }
        return supprimerPersonne;
    }

    public void afficher() {
        for (int i = 0; i < personnes.length; i++) {
            System.out.println(personnes[i]);
        }
    }

}
