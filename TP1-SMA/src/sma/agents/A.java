package sma.agents;

import jade.core.Agent;
import jade.wrapper.ControllerException;

public class A extends Agent{
	//cycle de vie de l’agent
	protected void setup() { 
		//au démarrage de l’agent
		System.out.println("Agent cree : "+getLocalName());
	}
	protected void takeDown() { 
		//à la terminaison de l’agent
		System.out.println("Agent detruit : "+getLocalName());
	}
	protected void beforeMove() { 
		//au niveau du container de départ
		try {
			System.out.println("Agent (" +getLocalName()+") part de : "
			+getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void afterMove() { 
		// au niveau du container d’arrivée
		try {
			System.out.println("Agent (" +getLocalName()+") arrive à : "
			+getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
