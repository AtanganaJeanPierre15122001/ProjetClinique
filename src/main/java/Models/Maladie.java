package Models;

public class Maladie {

    private  String Id_Maladie;

    private String Nom_Maladie;

    private String Symtomes;

    public Maladie(String id_Maladie, String nom_Maladie, String symtomes) {
        Id_Maladie = id_Maladie;
        Nom_Maladie = nom_Maladie;
        Symtomes = symtomes;
    }

    public String getId_Maladie() {
        return Id_Maladie;
    }

    public void setId_Maladie(String id_Maladie) {
        Id_Maladie = id_Maladie;
    }

    public String getNom_Maladie() {
        return Nom_Maladie;
    }

    public void setNom_Maladie(String nom_Maladie) {
        Nom_Maladie = nom_Maladie;
    }

    public String getSymtomes() {
        return Symtomes;
    }

    public void setSymtomes(String symtomes) {
        Symtomes = symtomes;
    }
}
