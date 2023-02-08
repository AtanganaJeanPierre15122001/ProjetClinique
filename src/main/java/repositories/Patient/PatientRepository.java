package repositories.Patient;


import Models.Patient;

import java.util.List;

public interface PatientRepository {

    void savePatient(Patient patient);

    List<Patient> getPatient();

    void updatePatient(Patient patient);

    void deletePatient(Patient patient );
}
