import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Admin;
import domain.Event;
import domain.RegisteredUser;
import domain.User;
import exceptions.EventFinished;
import exceptions.IncorrectLogin;
import exceptions.QuestionAlreadyExist;




    
@RunWith(MockitoJUnitRunner.class)
public class LoginMockTest {
	 DataAccess dataAccess=Mockito.mock(DataAccess.class);
     User mockedUser=Mockito.mock(User.class);
	
	@InjectMocks
	 BLFacade sut=new BLFacadeImplementation(dataAccess);
	
	@Test
	public void test1() {

			//define paramaters
			RegisteredUser user1 = new RegisteredUser("Inigo", "Gabirondo", "722553302B", "a@b.com", "user1", "si1234",
					null, "registered", "sdfdsf");
			Admin proba = new Admin("Inigo", "Zaldua", "722553302B", "x@gmail.com", "admin1", "si1234", null);
		
			
			//configure Mock
			Mockito.doReturn(user1).when(dataAccess).getUserByUsername(Mockito.anyString());
		

			//invoke System Under Test (sut) 
			try {
				int emaitza = sut.login("user1","si1234");
				if(emaitza ==1) {
					assertTrue(true);
				}else {
					fail();
				}
				
			} catch (IncorrectLogin e) {
				// TODO Auto-generated catch block
				fail();
			}
			
			ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
			ArgumentCaptor<String> username = ArgumentCaptor.forClass(String.class);
		
			
			Mockito.verify(dataAccess,Mockito.times(1)).getUserByUsername(username.capture());

			assertEquals(username.getValue(),user1.getUsername());
		}
		 
	@Test
	public void test2() {

			//define paramaters
			RegisteredUser user1 = new RegisteredUser("Inigo", "Gabirondo", "722553302B", "a@b.com", "user1", "si1234",
					null, "registered", "sdfdsf");
			Admin proba = new Admin("Inigo", "Zaldua", "722553302B", "x@gmail.com", "admin1", "si1234", null);
		
			
			//configure Mock
			Mockito.doReturn(proba).when(dataAccess).getUserByUsername(Mockito.anyString());
		

			//invoke System Under Test (sut) 
			try {
				int emaitza = sut.login("admin1","si1234");
				if(emaitza ==0) {
					assertTrue(true);
				}else {
					fail();
				}
				
			} catch (IncorrectLogin e) {
				// TODO Auto-generated catch block
				fail();
			}
			
			ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
			ArgumentCaptor<String> username = ArgumentCaptor.forClass(String.class);
		
			
			Mockito.verify(dataAccess,Mockito.times(1)).getUserByUsername(username.capture());

			assertEquals(username.getValue(),proba.getUsername());
			
		}
	
	@Test
	public void tes3() {

			//define paramaters
			RegisteredUser user1 = new RegisteredUser("Inigo", "Gabirondo", "722553302B", "a@b.com", "user1", "si1234",
					null, "registered", "sdfdsf");
			Admin proba = new Admin("Inigo", "Zaldua", "722553302B", "x@gmail.com", "admin1", "si1234", null);
		
			
			//configure Mock
			Mockito.doReturn(null).when(dataAccess).getUserByUsername("admin6");
		

			//invoke System Under Test (sut) 
			try {
				int emaitza = sut.login("admin1","si1234");
				fail();
				
			} catch (IncorrectLogin e) {
				// TODO Auto-generated catch block
				assertTrue(true);
			}
			ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
			ArgumentCaptor<String> username = ArgumentCaptor.forClass(String.class);
		
			
			Mockito.verify(dataAccess,Mockito.times(1)).getUserByUsername(username.capture());

			assertEquals(username.getValue(),proba.getUsername());
			
		}
	@Test
	public void tes4() {

			//define paramaters
			RegisteredUser user1 = new RegisteredUser("Inigo", "Gabirondo", "722553302B", "a@b.com", "user1", "si1234",
					null, "registered", "sdfdsf");
			Admin proba = new Admin("Inigo", "Zaldua", "722553302B", "x@gmail.com", "admin1", "si1234", null);
		
			
			//configure Mock
			Mockito.doReturn(null).when(dataAccess).getUserByUsername(null);
		

			//invoke System Under Test (sut) 
			try {
				int emaitza = sut.login(null,"si1234");
				fail();
				
			} catch (IncorrectLogin e) {
				// TODO Auto-generated catch block
				assertTrue(true);
			}
			
		}
	
	@Test
	public void tes5() {

			//define paramaters
			RegisteredUser user1 = new RegisteredUser("Inigo", "Gabirondo", "722553302B", "a@b.com", "user1", "si1234",
					null, "registered", "sdfdsf");
			Admin proba = new Admin("Inigo", "Zaldua", "722553302B", "x@gmail.com", "admin1", "si1234", null);
		
			
			//configure Mock
			Mockito.doReturn(user1).when(dataAccess).getUserByUsername(Mockito.anyString());
		

			//invoke System Under Test (sut) 
			try {
				int emaitza = sut.login("user1",null);
				fail();
				
			} catch (IncorrectLogin e) {
				// TODO Auto-generated catch block
				assertTrue(true);
			}
			
	
}
@Test
public void tes6() {

		//define paramaters
		RegisteredUser user1 = new RegisteredUser("Inigo", "Gabirondo", "722553302B", "a@b.com", "user1", "si1234",
				null, "registered", "sdfdsf");
		Admin proba = new Admin("Inigo", "Zaldua", "722553302B", "x@gmail.com", "admin1", "si1234", null);
	
		
		//configure Mock
		Mockito.doReturn(user1).when(dataAccess).getUserByUsername(Mockito.anyString());
	

		//invoke System Under Test (sut) 
		try {
			int emaitza = sut.login("user1","kaixo");
			fail();
			
		} catch (IncorrectLogin e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
		
	}






}
