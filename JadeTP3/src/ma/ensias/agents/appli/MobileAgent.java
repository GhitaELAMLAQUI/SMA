package ma.ensias.agents.appli;

import jade.core.Agent;
import java.util.Iterator;
import java.util.List;
import jade.core.Location;
import jade.core.behaviours.CyclicBehaviour;
import jade.wrapper.ControllerException;

public class MobileAgent extends Agent{
	List<Location> itinerary;
	int step=1;
	Location destination;
	// cycle de vie de l�agent
	protected void setup() { 
		// au d�marrage de l�agent
		System.out.println("Agent cree : " + getLocalName());
		//get itinerary passe par Argument
		itinerary = (List<Location>) getArguments()[0];
		
		//CuclicBehaviour pour le deplacement
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				Iterator<Location> iterator = itinerary.listIterator();	
				if(iterator.hasNext()) {
					destination = (Location) iterator.next();
					iterator.remove();
					step++;
					myAgent.doMove(destination); 
				}else {
					doDelete();
				}}});}
	protected void takeDown() { // � la terminaison de l�agent
		System.out.println("Agent detruit : " + getLocalName());
	}

	protected void beforeMove() { // au niveau du container de d�part
		try {
			System.out
					.println("Agent (" + getLocalName() + ") part de : " + getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}}

	protected void afterMove() { // au niveau du container d�arriv�e
		try {
			System.out.println(
					"Agent (" + getLocalName() + ") arrive � : " + getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}}}
