package ma.ensias.agents.env;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.ContainerController;

public class Plateforme {
	private ContainerController mainContainer, aContainer;
	public Plateforme() {
		Runtime rt = Runtime.instance(); //Créer une instance de la MV
		Properties p = new ExtendedProperties(); //fixer quelques propriétés
		p.setProperty("gui", "true"); //… le –gui entre autres
		ProfileImpl profile = new ProfileImpl(p);
		mainContainer = rt.createMainContainer(profile);
		profile = new ProfileImpl(false); // Ce n’est pas un main-container.
		// Associé au main-container démarré sur localhost
		profile.setParameter(ProfileImpl.MAIN_HOST, "localhost");
		aContainer = rt.createAgentContainer(profile);
	}
	public ContainerController getMainContainer(){ return mainContainer;}
	public ContainerController getAContainer(){ return aContainer;}
}
