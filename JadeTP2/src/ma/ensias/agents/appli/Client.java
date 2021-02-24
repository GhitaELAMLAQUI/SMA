package ma.ensias.agents.appli;

import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import ma.ensias.agents.env.Plateforme;

public class Client {
	public Client() {
		ContainerController container = new Plateforme().getAContainer();
		AgentController ac;
		try {
			ac = container.createNewAgent("A", A.class.getName(),
					new Object []{"Java Book",250.0}) ;
			ac.start();
			
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		}
		public static void main(String[] args) { new Client(); }
}
