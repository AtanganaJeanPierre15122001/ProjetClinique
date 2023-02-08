package repositories.Medecin;

import Models.Medecin;

import java.util.List;

public interface MedecinRepository {
    void saveMedecin(Medecin medecin);

    List<Medecin> getMedecin();

    void updateMedecin(Medecin medecin);

    void deleteMedecin(Medecin medecin);


}
