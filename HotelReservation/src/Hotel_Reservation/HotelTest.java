package Hotel_Reservation;

public class HotelTest {
	public static void main(String[] args) {
		Hotel hotel = new Hotel(20);
		hotel.reserveRoom("bangaram",15);
		hotel.reserveRoom("bangaram",10);
		hotel.reserveRoom("bangaram",9);
		hotel.reserveRoom("suneel");
		System.out.println(hotel.reserveRoom("suneel",10));
		hotel.cancelReservations("suneel");
		hotel.reserveRoom("minnu");
		hotel.printReservations();
	}
}
