package stockTradingServices;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class IOUtils {
public static ArrayList<Stock> restoreStockData(String filename) throws ClassNotFoundException, IOException {
	try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stocks.ser"))){
	
	return (ArrayList<Stock>)ois.readObject();
	}
	
}
}
