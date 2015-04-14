package pt.alkart.idemanager.main;

import java.util.List;

import pt.alkart.idemanager.objects.Idea;

public interface IdeManagerInt<K> {

	public boolean start();
	public boolean end();

	public K buildIdea(Idea ide);

	public void addIdea(Idea ide);

	public void removeIdea(Idea ide);

	public List<Idea> listIdeas();

}
