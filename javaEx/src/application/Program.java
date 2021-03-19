package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exception.DomainException;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date: ");
			Date checkOut = sdf.parse(sc.next());

			System.out.println("Reservation: ");
			Reservation rs = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(rs);

			System.out.println("-------------------------------------------------");

			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date: ");
			checkOut = sdf.parse(sc.next());

			rs.updateDates(checkIn, checkOut);
			System.out.println(rs);

		}
		catch (ParseException e) {
			System.out.print("Data invalida!!");
		}
		catch(DomainException e) {
			System.out.print("Erro na reserva" + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro não esperado!");
		}

		sc.close();
	}

}
