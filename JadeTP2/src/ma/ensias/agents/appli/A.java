package ma.ensias.agents.appli;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class A extends Agent{
	String livre;
	double prix;

	protected void setup() {
		System.out.println("Agent "+getLocalName()+ " : créé");
		Object[]args= getArguments();
		livre = (String)args[0] ; // le livre et
		prix = new Double((double) args[1]); // le prix en arguments
		
		this.addBehaviour(new Behaviour() {
			@Override
			public boolean done() { return true; }//en fait OneShotBehaviour
			public void action() {
			 System.out.println("Agent "+ myAgent.getLocalName()+
			" : mission=> acheter "+livre+" a "+ prix +" dhs"); }
			});
		
		this.addBehaviour(new TickerBehaviour(this, 1000) {
			
			@Override
			protected void onTick() {
				// TODO Auto-generated method stub
				System.out.println("Agent "+myAgent.getLocalName()+
						" : cherche vendeur. tick="+getTickCount());	
			}
		});
		this.addBehaviour(new WakerBehaviour(this, 50000) {
			@Override
			protected void onWake() {
				// TODO Auto-generated method stub
				System.out.println("Agent "+myAgent.getLocalName()+
						": Bye...");
						myAgent.doDelete();
			}
		});
}
}
