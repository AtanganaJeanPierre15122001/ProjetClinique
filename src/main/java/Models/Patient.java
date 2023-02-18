package Models;



public class Patient {

    private String Id_Patient;

    private String Id_Examen;

    private String Nom_Patient;

    private String Prenom_Patient;


    public Patient(String Id_Patient,String Id_Examen, String Nom_Patient ,String Prenom_Patient){

        this.Id_Patient=Id_Patient;
        this.Id_Examen=Id_Examen;
        this.Nom_Patient=Nom_Patient;
        this.Prenom_Patient=Prenom_Patient;
    }

    public void setId_Patient(String id_Patient) {Id_Patient = id_Patient;}

    public void setId_Examen(String id_Examen) {Id_Examen = id_Examen;}

    public void setNom_Patient(String nom_Patient) {Nom_Patient = nom_Patient;}

    public void setPrenom_Patient(String prenom_Patient) {Prenom_Patient = prenom_Patient;}


    public String getId_Patient() {return Id_Patient;}

    public String getId_Examen() {return Id_Examen;}

    public String getNom_Patient() {return Nom_Patient;}

    public String getPrenom_Patient() {return Prenom_Patient;}

}
