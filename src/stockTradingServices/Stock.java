package stockTradingServices;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class Stock implements Serializable {
	private String stockId;
	private String stockName;
	private String companyName;
	private double price;
	private LocalDate closingDate;
	private int quantity;
	static int counter=0;
	
	public Stock(String stockName, String companyName, double price, LocalDate closingDate, int quantity) {
		super();
		this.stockId = String.valueOf(++counter);
		this.stockName = stockName;
		this.companyName = companyName;
		this.price = price;
		this.closingDate = closingDate;
		this.quantity = quantity;
	}
	
	public Stock() {
		super();
		this.stockId = String.valueOf(++counter);
	}

	
	public Stock(String stockId, int quantity) {
		super();
		this.stockId = stockId;
		this.quantity = quantity;
	}

	public Stock(String companyName) {
		super();
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "\nStock [stockId=" + stockId + ", stockName=" + stockName + ", companyName=" + companyName + ", price="
				+ price + ", closingDate=" + closingDate + ", quantity=" + quantity + "]";
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(companyName, other.companyName);
	}
	
	
	
}
