package Hopital_Main;
import java.sql.*;
import javax.swing.*;

/**
 * @author HALIOT Kylian
 * @author ANDRE Ophélie
 * @author COHEN Jérémy
 * @author MOLINARI Paul
 */
public class Hopital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Informations accès BDD
        String url = "jdbc:mysql://localhost:8889/hopital";
        String admin = "root";
        String pswd = "root";
        
        // Instance de connexion
        Connection connexion = null;
        
        try 
        {
            // On choisit le driver JDBC à utiliser
            Class.forName("com.mysql.jdbc.Driver");
            
            // On opère la connexion
            connexion = DriverManager.getConnection(url,admin,pswd);
            
            // On affiche un message pour valider la connexion
            JOptionPane.showMessageDialog(null, "Vous êtes connecté à : " + url);
        } 
        
        // On catch l'exception sur le driver
        catch (ClassNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "Classe introuvable" + ex.getMessage());

        } 
        
        // On catch les exceptions sur la connexion à la BDD
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "ERREUR JDBC: " + ex.getMessage());
        } 
        
        finally 
        {
            try 
            {
                if (connexion != null) 
                {
                    connexion.close();
                }
            } 
            
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
        }
        
        System.exit(0);

    }
}
