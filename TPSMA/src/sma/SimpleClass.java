package sma;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

public class SimpleClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Runtime runtime=Runtime.instance();
			ProfileImpl profileImpl=new ProfileImpl(false);
			profileImpl.setParameter(profileImpl.MAIN_HOST, "localhost");
			
			AgentContainer agentContainer=runtime.createAgentContainer(profileImpl);
			
			agentContainer.start();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
