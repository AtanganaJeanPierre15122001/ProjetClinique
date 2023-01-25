package Models;

public class Dossier {

    private String Id_Dossier;

    private String Id_Patient;

    private String Rapport;

    public Dossier(String id_Dossier, String id_Patient, String rapport) {
        Id_Dossier = id_Dossier;
        Id_Patient = id_Patient;
        Rapport = rapport;
    }

    public String getId_Dossier() {
        return Id_Dossier;
    }

    public void setId_Dossier(String id_Dossier) {
        Id_Dossier = id_Dossier;
    }

    public String getId_Patient() {
        return Id_Patient;
    }

    public void setId_Patient(String id_Patient) {
        Id_Patient = id_Patient;
    }

    public String getRapport() {
        return Rapport;
    }

    public void setRapport(String rapport) {
        Rapport = rapport;
    }
}
