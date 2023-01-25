package Models;

public class Examen {

    private String Id_Examen;

    private String Motif;



    public Examen(String id_Examen, String motif){

        this.Id_Examen=id_Examen;
        this.Motif=motif;

    }

    public String getId_Examen() {
        return Id_Examen;
    }

    public void setId_Examen(String id_Examen) {
        Id_Examen = id_Examen;
    }

    public String getMotif() {
        return Motif;
    }

    public void setMotif(String motif) {
        Motif = motif;
    }

}
