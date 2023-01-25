package Models;

public class Ordonnance {

    private String Id_Ordonnance;

    private String Instruction;

    private String Medicament;

    public Ordonnance(String id_Ordonnance, String instruction, String medicament) {
        Id_Ordonnance = id_Ordonnance;
        Instruction = instruction;
        Medicament = medicament;
    }

    public String getId_Ordonnance() {
        return Id_Ordonnance;
    }

    public void setId_Ordonnance(String id_Ordonnance) {
        Id_Ordonnance = id_Ordonnance;
    }

    public String getInstruction() {
        return Instruction;
    }

    public void setInstruction(String instruction) {
        Instruction = instruction;
    }

    public String getMedicament() {
        return Medicament;
    }

    public void setMedicament(String medicament) {
        Medicament = medicament;
    }
}
