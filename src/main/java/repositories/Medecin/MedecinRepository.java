package repositories.Medecin;




import Models.Medecin;

import java.sql.SQLException;
import java.util.List;

public interface MedecinRepository {
    int saveMedecin( Medecin medecin);



    List<Medecin> getMedecin();



    int updateMedecin(Medecin medecin);



    int deleteMedecin(String id);


    Medecin getMedecinId(String id) throws SQLException;
}
