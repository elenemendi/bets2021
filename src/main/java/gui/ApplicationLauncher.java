package gui;


import java.net.URL;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import Factory.BusinessLogicFactory;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;

public class ApplicationLauncher {
	private static BusinessLogicFactory f;
	
	public static void main(String[] args) {

		Lock lock = new ReentrantLock();
		
		ConfigXML c=ConfigXML.getInstance();
	
		System.out.println(c.getLocale());
		
		LanguageGUI l = new LanguageGUI();
		l.setVisible(true);
		
		//Locale.setDefault(new Locale(c.getLocale()));
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Locale: "+Locale.getDefault());
		
		
		//LoginGUI a = new LoginGUI();		
		try {
			
			BLFacade appFacadeInterface;
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			appFacadeInterface= BusinessLogicFactory.createBusinessLogic(c.isBusinessLogicLocal());
			MainGUI.setBussinessLogic(appFacadeInterface);

			}catch (Exception e) {	
			System.out.println("Error in ApplicationLauncher: "+e.toString());
		}
		//a.pack();
	}

}
