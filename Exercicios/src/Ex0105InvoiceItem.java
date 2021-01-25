
public class Ex0105InvoiceItem {
	private String id;
	private String desc;
	private int qty;
	private double unitPrice;
	
	public Ex0105InvoiceItem(String id, String desc, int qty, double unitPrice) {
		this.id = id;
		this.desc = desc;
		this.qty = qty;
		this.unitPrice = unitPrice;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public int getQty() {
		return this.qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getTotal() {
		return this.unitPrice*this.qty;
	}
	
	public String toString() {
		return "InvoiceItem[id=" + this.id + ",desc=" + this.desc + ",qty=" + this.qty + ",unitPrice=" + this.unitPrice + ']';
	}
}
