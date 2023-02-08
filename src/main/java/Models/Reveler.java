package Models;

public class Reveler {
     private String ID_Examen;

     private  String ID_Maladie;

    public Reveler(String ID_Examen, String ID_Maladie) {
        this.ID_Examen = ID_Examen;
        this.ID_Maladie = ID_Maladie;
    }

    public String getID_Examen() {
        return ID_Examen;
    }

    public void setID_Examen(String ID_Examen) {
        this.ID_Examen = ID_Examen;
    }

    public String getID_Maladie() {
        return ID_Maladie;
    }

    public void setID_Maladie(String ID_Maladie) {
        this.ID_Maladie = ID_Maladie;
    }
}
