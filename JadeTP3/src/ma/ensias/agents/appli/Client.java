package ma.ensias.agents.appli;

import java.util.ArrayList;
import java.util.List;

import jade.core.ContainerID;
import jade.core.Location;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import ma.ensias.agents.env.Plateform;
import jade.core.Runtime;

public class Client {
	AgentContainer mainContainer;
	List<Location> locations = new ArrayList<Location>();
	List<Location> itinerary = new ArrayList<Location>();
	//nombre des conteneurs
	int NbreContainers=6;

	public Client() {
		mainContainer = new Plateform().getAgentContainer();
		//creer une liste statique des conteneurs
		initLocations();
		startContainers();
		initItinerary();
		deploieMobileAgent();
	}
	public void deploieMobileAgent() {
		try {
			//depoloie un mobile Agent en lui passant l'itinerary dans le main container
			AgentController agent = mainContainer.createNewAgent("MA", MobileAgent.class.getName(),
					new Object[] { itinerary });
			agent.start();
		} catch (StaleProxyException e) { }}
	//creer itenerary de rang pair à partir de locations
	public void initItinerary() {
		for (int i = 0; i < NbreContainers; i += 2) {
			itinerary.add(locations.get(i));
		}}
	//start les containers
	public void startContainers() {
		for (Location loc : locations) {
			try {
				Runtime runtime = Runtime.instance();
				ProfileImpl profileImpl = new ProfileImpl(false);
				profileImpl.setParameter(ProfileImpl.MAIN_HOST, "localhost");
				profileImpl.setParameter(ProfileImpl.CONTAINER_NAME, loc.getName());
				AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);
				agentContainer.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}}
	}
	public void initLocations() {
		for (int i = 0; i <NbreContainers; i++) {
			locations.add(new ContainerID("c" + i, null));}}
	public static void main(String[] args) { new Client();}}
