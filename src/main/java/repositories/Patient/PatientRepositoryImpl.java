package repositories.Patient;


import Models.Patient;
import com.example.projetclinique.DatabaseConnection;
import database.MedecinContract;
import database.PatientContract;

import java.sql.*;
import java.util.List;

public class PatientRepositoryImpl implements PatientRepository{

    private Connection connection;

    public PatientRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public int savePatient(Patient patient) {
        int st=0;
        int a=0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            if(patient.getId_Patient().length() != 0 || patient.getId_Examen().length() != 0 || patient.getNom_Patient().length() != 0 || patient.getPrenom_Patient().length() != 0  ){
                Statement statement1 = connection.createStatement();
                ResultSet result1 = statement1.executeQuery("SELECT "+ PatientContract.ID_PATIENT_FIELD_NAME+" FROM "+PatientContract.TABLE_NAME+" WHERE ID_PATIENT = "+patient.getId_Patient()+" ");
                while (result1.next())
                {
                    a=a+1;
                }
                if(a!=1) {
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO " + PatientContract.TABLE_NAME + " ( " + PatientContract.ID_PATIENT_FIELD_NAME + "," + PatientContract.ID_PATIENT_EXAM_CATEGORY_FIELD_NAME + "," + PatientContract.NOM_PATIENT_FIELD_NAME + "," + PatientContract.PRENOM_PATIENT_FIELD_NAME + " ) VALUES (?,?,?,?)");
                    statement.setString(1, patient.getId_Patient());
                    statement.setString(2, patient.getId_Examen());
                    statement.setString(3, patient.getNom_Patient());
                    statement.setString(4, patient.getPrenom_Patient());
                    st = statement.executeUpdate();
                }
                else {
                    st=2;
                }

            }else {
                st=-1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }



    @Override
    public List<Patient> getPatient() {
        return null;
    }

    @Override
    public int updatePatient(Patient patient) {
        int st=0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE " + PatientContract.TABLE_NAME + " SET " + PatientContract.ID_PATIENT_EXAM_CATEGORY_FIELD_NAME + "= ? ," + PatientContract.NOM_PATIENT_FIELD_NAME + "= ? ," + PatientContract.PRENOM_PATIENT_FIELD_NAME + "= ? WHERE "+PatientContract.ID_PATIENT_FIELD_NAME+"= ?") ;

            statement.setString(1, patient.getId_Examen());
            statement.setString(2, patient.getNom_Patient());
            statement.setString(3, patient.getPrenom_Patient());
            statement.setString(4, patient.getId_Patient());

            st = statement.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(st);
        return st;


    }

    @Override
    public int deletePatient(String id) {
        int st=0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + PatientContract.TABLE_NAME + "    WHERE "+PatientContract.ID_PATIENT_FIELD_NAME+"= ? ") ;

            statement.setString(1, id);


            st = statement.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return st;
    }

    @Override
    public Patient getPatientId(String id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + PatientContract.TABLE_NAME + " WHERE " + PatientContract.ID_PATIENT_FIELD_NAME + "= ? ");

        statement.setString(1, id);

        ResultSet resulset = statement.executeQuery();

        Patient patient = null;
        if (resulset.next()) {
            patient = new Patient(resulset.getString(1), resulset.getString(2), resulset.getString(3), resulset.getString(4));
        }
        return patient;
    }
}
