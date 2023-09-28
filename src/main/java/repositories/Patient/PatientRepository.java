package repositories.Patient;




import Models.Patient;

import java.sql.SQLException;
import java.util.List;

public interface PatientRepository {

    int savePatient(Patient patient);

    List<Patient> getPatient();

    int updatePatient(Patient patient);

    int deletePatient( String id);

    Patient getPatientId(String id) throws SQLException;
}
