package ma.ensias.agents.env;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.ContainerController;
import jade.wrapper.ControllerException;

public class Plateform {
	AgentContainer agentContainer;
	public Plateform() {
		try {
			Runtime runtime=Runtime.instance();
			Properties  properties=new ExtendedProperties();
			properties.setProperty(Profile.GUI, "true");
			ProfileImpl profileImpl=new ProfileImpl(properties);
			agentContainer=runtime.createMainContainer(profileImpl);
			agentContainer.start();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public AgentContainer getAgentContainer() {
		return agentContainer;
	}
	public void setAgentContainer(AgentContainer agentContainer) {
		this.agentContainer = agentContainer;
	}
}
