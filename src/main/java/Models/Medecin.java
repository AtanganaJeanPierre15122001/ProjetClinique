package Models;



public class Medecin {

    private String Id_Medecin;

    private   String Nom_Medecin;

    private String Prenom_Medecin;

    private String Titre_Medecin;



    public Medecin(String id_Medecin, String nom_Medecin, String prenom_Medecin, String titre_Medecin) {
        Id_Medecin = id_Medecin;
        Nom_Medecin = nom_Medecin;
        Prenom_Medecin = prenom_Medecin;
        Titre_Medecin = titre_Medecin;
    }

    public String getId_Medecin() {
        return Id_Medecin;
    }


    public void setId_Medecin(String id_Medecin) {
        Id_Medecin = id_Medecin;
    }

    public String getNom_Medecin() {
        return Nom_Medecin;
    }

    public void setNom_Medecin(String nom_Medecin) {
        Nom_Medecin = nom_Medecin;
    }

    public String getPrenom_Medecin() {
        return Prenom_Medecin;
    }

    public void setPrenom_Medecin(String prenom_Medecin) {
        Prenom_Medecin = prenom_Medecin;
    }

    public String getTitre_Medecin() {
        return Titre_Medecin;
    }

    public void setTitre_Medecin(String titre_Medecin) {
        Titre_Medecin = titre_Medecin;
    }
}
