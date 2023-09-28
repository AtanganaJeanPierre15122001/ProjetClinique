package Models;

public class Examen {



    private String Id_Examen;

    private String Nom_Exa;


    public Examen(String id_Examen, String nom_Exa) {
        Id_Examen = id_Examen;
        Nom_Exa = nom_Exa;
    }

    public String getId_Examen() {
        return Id_Examen;
    }

    public void setId_Examen(String id_Examen) {
        Id_Examen = id_Examen;
    }

    public String getNom_Exa() {
        return Nom_Exa;
    }

    public void setNom_Exa(String nom_Exa) {
        Nom_Exa = nom_Exa;
    }
}
