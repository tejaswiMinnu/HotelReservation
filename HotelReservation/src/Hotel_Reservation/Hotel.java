package Hotel_Reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hotel {
	private List<Reservation> totalRooms;
	private Map<String,List<Reservation>> reservedRooms;
	
	public Hotel(){
		
	}
	public Hotel(int numberOfRooms){
		totalRooms = new ArrayList<Reservation>();
		reservedRooms = new HashMap<String,List<Reservation>>();
		for(int i=0;i<numberOfRooms;i++){
			Reservation reservation = new Reservation(i+1,null);
			totalRooms.add(reservation);
		}
		//System.out.println(totalRooms);
	}
	public int reserveRoom(String person){
		int freeRoomIndex = getAFreeRoom();
		if(freeRoomIndex == -1){
			return -1;
		}
		Reservation r = totalRooms.get(freeRoomIndex);
		r.setCustomerName(person);
		r.setReserved(true);
		if(reservedRooms.containsKey(person)){
			List<Reservation> reservations = reservedRooms.get(person);
			reservations.add(r);
		} else {
			List<Reservation> reservations = new ArrayList<Reservation>();
			reservations.add(r);
			reservedRooms.put(person, reservations);
		}
		//reservedRooms.put(person, r);
		return r.getRoomNo();
	}
	
	public boolean reserveRoom(String person,int roomNum){
		Reservation r = getRoomByRoomNo(roomNum);
		if(r == null){
			return false;
		}
		r.setReserved(true);
		r.setCustomerName(person);
		if(reservedRooms.containsKey(person)){
			List<Reservation> reservations = reservedRooms.get(person);
			reservations.add(r);
		} else {
			List<Reservation> reservations = new ArrayList<Reservation>();
			reservations.add(r);
			reservedRooms.put(person, reservations);
		}
		return true;
	}
	
	public void cancelReservations(String person){
		List<Reservation> reservations = reservedRooms.get(person);
		for(int i=0;i<reservations.size();i++){
			Reservation r = reservations.get(i);
			r.setReserved(false);
			r.setCustomerName(null);
			clearRoomByRoomId(r.getRoomNo());
		}
		reservedRooms.remove(person);
	}
	
	public void printReservations(){
		Set<String> personSet = reservedRooms.keySet();
		Iterator<String> itr = personSet.iterator();
		while(itr.hasNext()){
			String person = itr.next();
			System.out.println(person + "    " + reservedRooms.get(person));
		}
	}
	
	public int getAFreeRoom(){
		for(int i=0;i<totalRooms.size();i++){
			Reservation r = totalRooms.get(i);
			if(!r.isReserved()){
				return i;
			}
		}
		return -1;
	}
	
	public Reservation getRoomByRoomNo(int roomNo){
		for(int i=0;i<totalRooms.size();i++){
			Reservation r = totalRooms.get(i);
			if(r.getRoomNo()==roomNo && !r.isReserved()){
				return r;
			}
		}
		
		return null;
	}
	
	public int getRoomIndexByRoomNo(int roomNo){
		for(int i=0;i<totalRooms.size();i++){
			Reservation r = totalRooms.get(i);
			if(r.getRoomNo()==roomNo && !r.isReserved()){
				return i;
			}
		}
		
		return -1;
	}
	
	public void clearRoomByRoomId(int roomNum){
		int index = getRoomIndexByRoomNo(roomNum);
		if(index != -1){
			totalRooms.get(index).setReserved(false);
			totalRooms.get(index).setCustomerName(null);
		}
		
	}
	
}
