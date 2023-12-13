package stockTradingServices;
import static stockTradingServices.CollectionUtils.populateStock; // utils.CollectionUtils.populateStock;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import CustomExceptions.InvalidDateInputException;

public class Tester {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			ArrayList<Stock> finalStockList = populateStock();
			
			
			while(true) {
				System.out.println("Choose from following menu: ");
				System.out.println("\n1.Add new stock in market.");
				System.out.println("\n2.View available stocks by company.");
				System.out.println("\n3.Purchase stock");
				System.out.println("\n4.Sale stock");
				System.out.println("\n5.Display the stocklist");
				System.out.println("\n6.Save and exit.");
				
				switch(sc.nextInt()) {
				case 1:
					Stock st= new Stock();
					System.out.println("Enter stock name");
					st.setStockName(sc.next());
					System.out.println("Enter company name");
					st.setCompanyName(sc.next());
					System.out.println("Enter price");
					st.setPrice(sc.nextDouble());
					System.out.println("Enter closing date in the format yyyy-MM-dd");
					String date=sc.next();
					
					
						int dateComaparison=LocalDate.parse(date).compareTo(LocalDate.now());
							if(dateComaparison<0) {
								throw new InvalidDateInputException("PLease enter valid future date");
							}
						
					st.setClosingDate(LocalDate.parse(date));
					
					
					System.out.println("Enter quantity");
					st.setQuantity(sc.nextInt());
					
					finalStockList.add(st);
					System.out.println("Stock added successfully!!!");
					break;
					
				case 2:
				
					System.out.println("Enter company name to view their available stocks");
					String companyNameFromUser=sc.next();
					Stock st1= new Stock(companyNameFromUser);
					for(Stock s : finalStockList) {
						if(s.getCompanyName().equals(st1.getCompanyName()))
						{
							if(s.getQuantity()>0) {
							System.out.println(s);
							  }
							}
					}
					break;
				case 3:
					System.out.println("Please enter Stock ID you want to purchase ");
					String stockIdFromUser=sc.next();
					
					System.out.println("Please enter quantity you want to purchase ");
					int quantityFromUser=sc.nextInt();
					Stock st2=new Stock(stockIdFromUser,quantityFromUser);
					for(Stock s1: finalStockList) {
						if(s1.getStockId().equals(st2.getStockId())) {
							if(s1.getQuantity()>st2.getQuantity()) {
								s1.setQuantity(s1.getQuantity()-st2.getQuantity());
								System.out.println("Purchase succesfull");
							}
						}
						
					}
					
					break;
				case 4:
					System.out.println("Enter stock id you want to sell");
					String stockId1=sc.next();
					System.out.println("please enter quantity you want to sell");
					int quantity=sc.nextInt();
					for(Stock s2 : finalStockList) {
						if(s2.getStockId().equals(stockId1)) {
							System.out.println("found");
						s2.setQuantity(s2.getQuantity()+quantity);
						System.out.println(s2.toString());
						}
					}
					
					break;
					
				case 5:
					System.out.println(finalStockList);
					break;
				case 6:
					//for creating a file
					FileOutputStream fos= new FileOutputStream("stocks.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(finalStockList);
					System.out.println("List saved in the file successfully.");
					
					
//					//for reading
//				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stocks.ser"));
//				ois.read();
					
					//for writing into file
					
//					
					break;
				}
			}
			
		}
		catch(InvalidDateInputException e){
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
