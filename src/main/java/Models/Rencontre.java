package Models;

import java.util.Date;

public class Rencontre {

    private String ID_Maladie;

    private String ID_Patient;

    private String ID_Ordonnance;

    private Date Date_Rencontre;

    public Rencontre(String ID_Maladie, String ID_Patient, String ID_Ordonnance, Date date_Rencontre) {
        this.ID_Maladie = ID_Maladie;
        this.ID_Patient = ID_Patient;
        this.ID_Ordonnance = ID_Ordonnance;
        Date_Rencontre = date_Rencontre;
    }

    public String getID_Maladie() {
        return ID_Maladie;
    }

    public void setID_Maladie(String ID_Maladie) {
        this.ID_Maladie = ID_Maladie;
    }

    public String getID_Patient() {
        return ID_Patient;
    }

    public void setID_Patient(String ID_Patient) {
        this.ID_Patient = ID_Patient;
    }

    public String getID_Ordonnance() {
        return ID_Ordonnance;
    }

    public void setID_Ordonnance(String ID_Ordonnance) {
        this.ID_Ordonnance = ID_Ordonnance;
    }

    public Date getDate_Rencontre() {
        return Date_Rencontre;
    }

    public void setDate_Rencontre(Date date_Rencontre) {
        Date_Rencontre = date_Rencontre;
    }
}
