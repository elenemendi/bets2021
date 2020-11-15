package Factory;

import java.net.URL;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import gui.MainGUI;

public class BusinessLogicFactory {
	public static BLFacade createBusinessLogic (boolean isLocal) {
		try {

			BLFacade appFacadeInterface;
			if (isLocal) {
				ConfigXML c = ConfigXML.getInstance();
				System.out.println("sartu"+c.getDataBaseOpenMode().equals("initialize"));

				DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
				appFacadeInterface=new BLFacadeImplementation(da);
			}
			else { //If remote
				//String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";

				URL url = new URL("http://localhost:9999/ws/ruralHouses?wsdl");
				//URL url = new URL(serviceName);
				//1st argument refers to wsdl document above
				//2nd argument is service name, refer to wsdl document above
				//		        QName qname = new QName("http://businessLogic/", "FacadeImplementationWSService");
				QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");

				Service service = Service.create(url, qname);

				appFacadeInterface = service.getPort(BLFacade.class);
			} 
			/*if (c.getDataBaseOpenMode().equals("initialize")) 
				appFacadeInterface.initializeBD();
			 */
			return appFacadeInterface;

		}catch (Exception e) {	
			System.out.println("Error in ApplicationLauncher: "+e.toString());
		}
		//a.pack();
		return null;
	}

}
