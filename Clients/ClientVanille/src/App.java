import accesseur.cache.PenseeDAO;
import outils.Journal;
import vue.VueInspirationVisuelle;

public class App {

	public static void main(String[] parametres) {

		PenseeDAO cachePenseeDAO = new PenseeDAO();
		cachePenseeDAO.listerPensees();

		//Journal.activer();
		Journal.activerNiveau(0);

		//Pensee pensee = new Pensee("Rossetti","Ce qui est plus triste qu une oeuvre inachevee, c est une oeuvre jamais commencee.");
		//penseeDAO.ajouterPensee(pensee);

		VueInspirationVisuelle.launch(VueInspirationVisuelle.class, parametres);


	}

}