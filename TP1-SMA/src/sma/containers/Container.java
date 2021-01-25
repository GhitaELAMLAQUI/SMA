package sma.containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class Container {

	public static void main(String[] args) {
		try {
			Runtime runtime=Runtime.instance();
			ProfileImpl profileImpl=new ProfileImpl(false);
			profileImpl.setParameter(profileImpl.MAIN_HOST, "localhost");
			
			AgentContainer agentContainer=runtime.createAgentContainer(profileImpl);
			
			//Deploy the agent
			AgentController agentController = agentContainer.createNewAgent("B007",
					"sma.agents.A", new Object[] {});
			
			agentController.start();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
