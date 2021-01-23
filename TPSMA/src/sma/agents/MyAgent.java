package sma.agents;

import jade.core.Agent;
import jade.wrapper.ControllerException;

public class MyAgent extends Agent{
	@Override
	protected void setup() {
		System.out.println("Creation et initialisation de l'agent: "+this.getAID().getName());
	}
	@Override
	protected void beforeMove() {
		try {
			System.out.println("Avant migration de l'agent: "+this.getAID().getName());
			System.out.println("De "+this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void afterMove() {
		try {
			System.out.println("Apres migration de l'agent: "+this.getAID().getName());
			System.out.println("Vers "+this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void takeDown() {
		System.out.println("L'agent: "+this.getAID().getName()+" va mourir");
	}

}
