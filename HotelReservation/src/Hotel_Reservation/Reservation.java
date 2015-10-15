package Hotel_Reservation;

public class Reservation {
	private int roomNo;
	private String customerName;
	private boolean isReserved;
	
	public Reservation(){
	
	}
	
	public Reservation(int roomNo,String customerName){
		this.roomNo = roomNo;
		this.customerName = customerName;
		this.isReserved = false;
	}
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	@Override
	public String toString() {
		return "Reservation [roomNo=" + roomNo + ", customerName="
				+ customerName + ", isReserved=" + isReserved + "]";
	}
	
}
