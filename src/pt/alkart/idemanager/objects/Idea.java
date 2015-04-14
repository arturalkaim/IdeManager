package pt.alkart.idemanager.objects;

import java.util.LinkedList;
import java.util.List;

public class Idea {

	public static final String NAME = "Name";
	public static final String DESC = "Description";

	private String name;
	private List<String> desc;

	public Idea(String name, String desc) {
		this.desc = new LinkedList<String>();
		this.desc.add(desc);
		this.name = name;
	}

	public Idea(String name, List<String> list) {
		this.desc = list;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<String> getDesc() {
		return desc;
	}

	public void appendDesc(String newDesc) {
		desc.add(newDesc);
	}

	@Override
	public String toString() {
		return "*** Idea ***" + "\n" 
				+ NAME + ": " + name + "\n" 
				+ DESC + ": " + descToString();
	}

	private String descToString() {
		String d = "";
		for (String de : desc) {
			d += "\t" + de + "\n";
		}
		return d;
	}

}
