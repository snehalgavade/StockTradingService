package stockTradingServices;

import java.time.LocalDate;
import java.util.ArrayList;

public class CollectionUtils {
	@SuppressWarnings("deprecation")
	public static ArrayList<Stock> populateStock(){
		ArrayList<Stock> stockList = new ArrayList<>();
		stockList.add(new Stock("stock1","company1",1000.0, LocalDate.parse("2022-02-02"), 10));
		stockList.add(new Stock("stock2","company2",1500.0, LocalDate.parse("2023-02-02"), 0));
		stockList.add(new Stock("stock3","company1",900.0, LocalDate.parse("2021-05-10"), 4));
		stockList.add(new Stock("stock4","company2",1200.0, LocalDate.parse("2023-04-15"), 5));
		stockList.add(new Stock("stock5","company2",1100.0, LocalDate.parse("2022-10-14"), 2));
	
		return stockList;
	}
}
