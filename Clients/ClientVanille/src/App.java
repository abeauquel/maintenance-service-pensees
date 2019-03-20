import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import accesseur.PenseeDAO;
import modele.Pensee;
import outils.Journal;
import vue.VueInspirationVisuelle;

public class App {

	public static void main(String[] parametres) {

		String DSN = "jdbc:sqlite:C:/sqlite/bases/inspiration.cache.db";
		String SQL_ENREGISTRER_PENSEE = "insert into pensee(auteur, message) values('','')";
		String SQL_LISTER_PENSEES = "SELECT * FROM pensee";

		Connection basededonnees = null;
		try {
			basededonnees = DriverManager.getConnection(DSN);
			Statement requeteListePensees = basededonnees.createStatement();
			ResultSet curseurListePensees = requeteListePensees.executeQuery(SQL_LISTER_PENSEES);
			curseurListePensees.next();
			String auteur = curseurListePensees.getString("auteur");
			String pensee = curseurListePensees.getString("message");
			System.out.println(auteur + " - " + pensee);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Journal.activer();
		Journal.activerNiveau(0);

		//Pensee pensee = new Pensee("Rossetti","Ce qui est plus triste qu une oeuvre inachevee, c est une oeuvre jamais commencee.");
		//penseeDAO.ajouterPensee(pensee);

		VueInspirationVisuelle.launch(VueInspirationVisuelle.class, parametres);


	}

}