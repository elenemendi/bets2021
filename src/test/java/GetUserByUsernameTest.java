import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.RegisteredUser;
import domain.User;
import exceptions.QuestionAlreadyExist;
import test.businessLogic.TestFacadeImplementation;

public class GetUserByUsernameTest {
	 static DataAccess sut=new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));;
	 static TestFacadeImplementation testBL=new TestFacadeImplementation();;

	
	
	@Test
	public void test1() {			
			//define paramaters
			RegisteredUser newUser = new RegisteredUser("Inigo", "Gabirondo", "722553302B", "a@b.com", "user1", "si1234",
					null, "registered", "sdfdsf");
			
			RegisteredUser u = testBL.addUser(newUser);
			try {
				if(sut.getUserByUsername(newUser.getUsername()).equals(null)){
					fail();
				}else {
					System.out.println("kaka print" + sut.getUserByUsername(newUser.getUsername()));
					assertTrue(true);
					
				}
				
			}finally {
				  //Remove the created objects in the database (cascade removing)   
		          boolean b=testBL.removeUser(u);
		           System.out.println("Finally1 "+b);          
		        }
		   }
	
	@Test
	public void test2() {			
			//define paramaters
			RegisteredUser newUser = new RegisteredUser("Inigo", "Gabirondo", "722553302B", "a@b.com", "user1", "si1234",
					null, "registered", "sdfdsf");
			
			RegisteredUser u = testBL.addUser(newUser); 
			try {
				if(sut.getUserByUsername("user8")==null){
					assertTrue(true);
				}else {
					fail();
				}
				
			}finally {
				  //Remove the created objects in the database (cascade removing)   
		          boolean b=testBL.removeUser(u);
		           System.out.println("Finally2 "+b);          
		        }
		   }
	
	@Test
	public void test3() {			
		if(sut.getUserByUsername(null) == null){
			assertTrue(true);
		}else {
			fail();
			}
				
	
	}

			
}
