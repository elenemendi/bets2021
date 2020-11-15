package adapter;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Bet;
import domain.RegisteredUser;
import domain.User;

public class UserAdapter extends AbstractTableModel {
	
	private  List<Bet> bets; 
	private RegisteredUser user; 
	private String[] colNames = new String[] {"Event", "Question", "EventDate", "Money (€)"}; 	
	
	
	public UserAdapter(RegisteredUser u){
		this.bets=u.getBets();
		this.user=u;
	}
	
	public String getColumnName(int col) {
		  return colNames[col];
		 }

	@Override
	public int getColumnCount() {
		return 4;
	}
	@Override
	public int getRowCount() {
		return bets.size();
	}
	@Override
	public Object getValueAt(int columnIndex, int rowIndex) {
		switch(columnIndex) { 
		case 0: 
			return bets.get(rowIndex).getFee().getQuestion().getEvent();
		case 1: 
			return bets.get(rowIndex).getFee().getQuestion(); 
		case 2:
			return bets.get(rowIndex).getFee().getQuestion().getEvent().getEventDate();
		case 3:
			return bets.get(rowIndex).getBetMoney();
			
		}        
		return null; 
	}

}
