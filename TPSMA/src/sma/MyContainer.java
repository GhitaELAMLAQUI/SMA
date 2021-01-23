package sma;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class MyContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Runtime runtime=Runtime.instance();
			ProfileImpl profileImpl=new ProfileImpl(false);
			profileImpl.setParameter(profileImpl.MAIN_HOST, "localhost");
			
			AgentContainer agentContainer=runtime.createAgentContainer(profileImpl);
			
			//Deployer l'agent
			AgentController agentController = agentContainer.createNewAgent("etudiant",
					"sma.agents.MyAgent", new Object[] {});
			
			agentController.start();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
