package ma.ensias.agents.appli;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.Agent;
import jade.core.ContainerID;
import jade.core.Location;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPANames;
import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.domain.JADEAgentManagement.QueryPlatformLocationsAction;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.wrapper.ControllerException;

public class MobileAgent2 extends Agent {
	List<Location> itinerary=new ArrayList<Location>();
	int step = 1;
	Location destination;
	// cycle de vie de l’agent
	protected void setup() {
		// au démarrage de l’agent
		System.out.println("Agent cree : " + getLocalName());
		// get itinerary passe par Argument
		addBehaviour(new OneShotBehaviour(this) {

			@Override
			public void action() {
				// get List Containers à partir l'AMS
				try {
					Action action = new Action(getAMS(),null);
					action.setAction(new QueryPlatformLocationsAction());

					ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
					request.addReceiver(getAMS());
					request.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
					request.setOntology(JADEManagementOntology.NAME);
					request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

					getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL);
					getContentManager().registerOntology(JADEManagementOntology.getInstance());
					getContentManager().fillContent(request, action);

					send(request);

					ACLMessage receivedMessage = blockingReceive(MessageTemplate.MatchSender(getAMS()));
					Result result = (Result) getContentManager().extractContent(receivedMessage);
					jade.util.leap.List listOfContainers = (jade.util.leap.List) result.getValue();
					
					for (int i = 0; i < listOfContainers.size(); i++) {
						if(!listOfContainers.get(i).toString().substring(0,1).equals("M") &&
								Integer.parseInt(listOfContainers.get(i).toString().substring(1,2))%2==1
								) {
							itinerary.add(new ContainerID(listOfContainers.get(i).toString().substring(0,2).toString(),null));
						}}} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();}}});

		// CuclicBehaviour pour le deplacement
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				Iterator<Location> iterator = itinerary.listIterator();
				if (iterator.hasNext()) {
					destination = (Location) iterator.next();
					iterator.remove();
					step++;
					myAgent.doMove(destination);
				} else {
					doDelete();}}});}
	protected void takeDown() { // à la terminaison de l’agent
		System.out.println("Agent detruit : " + getLocalName());
	}

	protected void beforeMove() { // au niveau du container de départ
		try {
			System.out
					.println("Agent (" + getLocalName() + ") part de : " + getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}}
	protected void afterMove() { // au niveau du container d’arrivée
		try {
			System.out.println(
					"Agent (" + getLocalName() + ") arrive à : " + getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}}}
