package pt.alkart.idemanager.main.tests;

import pt.alkart.idemanager.managers.IdeManager_MYSQL;

public class TestMySQL {

	public static void main(String[] args) {
		IdeManager_MYSQL idm = new IdeManager_MYSQL();
		idm.start();
		
		
		idm.end();
	}

}
