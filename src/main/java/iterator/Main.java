package iterator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Factory.BusinessLogicFactory;
import businessLogic.BLFacade;
import domain.Event;

public class Main {

	public static void main(String[] args) {
		
		boolean isLocal=true;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = sdf.parse("17/12/2020");
			//Facade objektua lortu lehendabiziko ariketa erabiliz
			BLFacade blInterface= (new BusinessLogicFactory()).createBusinessLogic(isLocal);
			ExtendedIterator<Event> i=blInterface.getEvents(date);
			Event ev;
			i.goLast();
			System.out.println("ATZETIK AURRERA");
			while(i.hasPrevious()){
				ev=i.previous();
				System.out.println(ev.toString());

			}
			//Nahiz eta suposatu hasierara ailegatu garela, eragiketa egiten dugu. 
			i.goFirst();
			System.out.println("AURRETIK ATZERA");
			while(i.hasNext()){
				
				ev=(Event) i.next();
				System.out.println(ev.toString());
			 }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
