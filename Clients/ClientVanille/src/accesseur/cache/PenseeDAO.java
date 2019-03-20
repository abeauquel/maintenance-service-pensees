
package accesseur.cache;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.DecodeurPenseesXML;
import modele.Pensee;
import outils.JournalDesactivable;

public class PenseeDAO implements PenseeURL{

    protected DecodeurPenseesXML decodeur = new DecodeurPenseesXML();

    public List<Pensee> listerPensees()
    {
        List<Pensee> listePensees = new ArrayList<Pensee>();
        JournalDesactivable.ecrire("CachePenseeDAO.listerPensees()");
        Connection basededonnees = null;
        ResultSet curseurListePensees;
        try {
            basededonnees = DriverManager.getConnection(DSN);
            Statement requeteListePensees = basededonnees.createStatement();
            curseurListePensees = requeteListePensees.executeQuery(SQL_LISTER_PENSEES);
            if(curseurListePensees == null) return listePensees; //return null;
            while(curseurListePensees.next())
            {
                String auteur = curseurListePensees.getString("auteur");
                String message = curseurListePensees.getString("message");
                //System.out.println(auteur + " - " + message);
                listePensees.add(new Pensee(auteur, message));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listePensees;
    }

    public void enregistrerPensee(Pensee pensee)
    {
        JournalDesactivable.ecrire("CachePenseeDAO.enregistrerPensees()");
        Connection basededonnees = null;

        try {
            basededonnees = DriverManager.getConnection(DSN);
            PreparedStatement requeteEnregistrerPensee = basededonnees.prepareStatement(SQL_ENREGISTRER_PENSEE);
            requeteEnregistrerPensee.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}