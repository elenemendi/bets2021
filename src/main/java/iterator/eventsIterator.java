package iterator;
import java.util.List;

import domain.Event;


public class eventsIterator implements ExtendedIterator<Event> {
	List<Event> events;
	int position;
	
	public eventsIterator (List<Event> e) {
		this.events = e;
		this.position=0;
	}	
	//uneko elementua itzultzen du eta aurrekora pasatzen da
		public Event previous() {
			Event res = events.get(position);
			position --;
			return res;			
		}		
		//true aurreko elementua existitzen bada.
		public boolean hasPrevious() {
			return position>=0;
		}		
		//Lehendabiziko elementuan kokatzen da. 
		public void goFirst() {
			this.position=0;
		}
		//Azkeneko elementuan kokatzen da.
		public void goLast() {
			this.position=this.events.size()-1;
		}
		public boolean hasNext() {
			return position<events.size();
		}
		public Object next() {
			Event res = events.get(position);
			position ++;
			return res;
			
		}


}
