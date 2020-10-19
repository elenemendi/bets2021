package test.businessLogic;


import java.util.Date;

import configuration.ConfigXML;
import domain.Event;
import domain.RegisteredUser;
import domain.User;
import exceptions.IncorrectLogin;
import test.dataAccess.TestDataAccess;

public class TestFacadeImplementation {
	TestDataAccess dbManagerTest;
 	
    
	   public TestFacadeImplementation()  {
			
			System.out.println("Creating TestFacadeImplementation instance");
			ConfigXML c=ConfigXML.getInstance();
			dbManagerTest=new TestDataAccess(); 
			dbManagerTest.close();
		}
		
		 
		public boolean removeEvent(Event ev) {
			dbManagerTest.open();
			boolean b=dbManagerTest.removeEvent(ev);
			dbManagerTest.close();
			return b;

		}
		
		public Event addEvent(String desc, Date d) {
			dbManagerTest.open();
			Event o=dbManagerTest.addEvent(desc,d);
			dbManagerTest.close();
			return o;

		}
		
		public RegisteredUser addUser(RegisteredUser u) {
			dbManagerTest.open();
			RegisteredUser us= dbManagerTest.insertRegisteredUser(u);
			dbManagerTest.close();
			return us;
		}
		
		
		public boolean removeUser(RegisteredUser u) { 
			dbManagerTest.open();
			boolean b = dbManagerTest.removeRegisteredUser(u);
			dbManagerTest.close();
			return b;
		}
		
	

}
