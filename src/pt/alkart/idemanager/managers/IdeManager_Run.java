package pt.alkart.idemanager.managers;

import java.util.List;

import pt.alkart.idemanager.main.IdeManagerInt;
import pt.alkart.idemanager.objects.Idea;

public class IdeManager_Run implements IdeManagerInt<Idea> {

	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean end(){
		return true;
	}

	@Override
	public Idea buildIdea(Idea ide) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void addIdea(Idea ide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeIdea(Idea ide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Idea> listIdeas() {
		return null;
		// TODO Auto-generated method stub
		
	}


}
