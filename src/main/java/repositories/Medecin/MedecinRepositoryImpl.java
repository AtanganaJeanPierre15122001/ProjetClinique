package repositories.Medecin;

import Models.Medecin;
import com.example.projetclinique.DatabaseConnection;
import database.MedecinContract;

import java.sql.*;
import java.util.List;

public class MedecinRepositoryImpl implements MedecinRepository {

    private Connection connection;

    public MedecinRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int saveMedecin(Medecin medecin) {
        int st=0;
        int a=0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            if(medecin.getId_Medecin().length() != 0 || medecin.getNom_Medecin().length() != 0 || medecin.getPrenom_Medecin().length() != 0 || medecin.getTitre_Medecin().length() != 0  ){
                Statement statement1 = connection.createStatement();
                ResultSet result1 = statement1.executeQuery("SELECT "+MedecinContract.ID_MEDECIN_FIELD_NAME+" FROM "+MedecinContract.TABLE_NAME+" WHERE ID_MEDECIN = "+medecin.getId_Medecin()+" ");
                while (result1.next())
                {
                    a=a+1;
                }
                if(a!=1) {
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO " + MedecinContract.TABLE_NAME + " ( " + MedecinContract.ID_MEDECIN_FIELD_NAME + "," + MedecinContract.NOM_MEDECIN_FIELD_NAME + "," + MedecinContract.PRENOM_MEDECIN_FIELD_NAME + "," + MedecinContract.TITRE_MEDECIN_FIELD_NAME + " ) VALUES (?,?,?,?)");
                    statement.setString(1, medecin.getId_Medecin());
                    statement.setString(2, medecin.getNom_Medecin());
                    statement.setString(3, medecin.getPrenom_Medecin());
                    statement.setString(4, medecin.getTitre_Medecin());
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
    public List<Medecin> getMedecin() {
        return null;
    }

    @Override
    public int updateMedecin(Medecin medecin) {

        int st=0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE " + MedecinContract.TABLE_NAME + " SET " + MedecinContract.NOM_MEDECIN_FIELD_NAME + "= ? ," + MedecinContract.PRENOM_MEDECIN_FIELD_NAME + "= ? ," + MedecinContract.TITRE_MEDECIN_FIELD_NAME + "= ? WHERE "+MedecinContract.ID_MEDECIN_FIELD_NAME+"= ?") ;

            statement.setString(1, medecin.getNom_Medecin());
            statement.setString(2, medecin.getPrenom_Medecin());
            statement.setString(3, medecin.getTitre_Medecin());
            statement.setString(4, medecin.getId_Medecin());

            st = statement.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return st;


    }



    @Override
    public int deleteMedecin(String id) {
        int st=0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + MedecinContract.TABLE_NAME + "    WHERE "+MedecinContract.ID_MEDECIN_FIELD_NAME+"= ? ") ;

            statement.setString(1, id);


            st = statement.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return st;


    }
    @Override
    public Medecin getMedecinId(String id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + MedecinContract.TABLE_NAME + " WHERE " + MedecinContract.ID_MEDECIN_FIELD_NAME + "= ? ");

        statement.setString(1, id);

        ResultSet resulset = statement.executeQuery();

        Medecin medecin = null;
        if (resulset.next()) {
            medecin = new Medecin(resulset.getString(1), resulset.getString(2), resulset.getString(3), resulset.getString(4));
        }
        return medecin;
    }
}
