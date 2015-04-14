package pt.alkart.idemanager.main.tests;

import pt.alkart.idemanager.managers.IdeManager_MONGODB;
import pt.alkart.idemanager.objects.Idea;

public class TestMongo {

	public static void main(String[] args) {
		IdeManager_MONGODB ideM = new IdeManager_MONGODB();
		ideM.start();
		Idea i1 = new Idea("IdeManager","Gestor de Ideias");
		i1.appendDesc("Crias uma ideia e desenvolves");
		i1.appendDesc("Fica tudo guardado numa BD");
		ideM.addIdea(i1);
		ideM.addIdea(new Idea("PantryManager","Manages the pantry"));
		
		ideM.listIdeas();
		ideM.end();
		
	}

}
