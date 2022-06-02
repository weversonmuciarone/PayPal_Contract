package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PayPalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data:");
		System.out.println("--------------------");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/mm/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value £: ");
		double contractValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, contractValue);
		
		System.out.print("Enter number of installments: ");
		int N = sc.nextInt();
		
		ContractService cs = new ContractService(new PayPalService());
		cs.processContract(contract, N);
		System.out.println();
		
		System.out.println("INSTALLMENTS:");
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		
		sc.close();
	}

}
