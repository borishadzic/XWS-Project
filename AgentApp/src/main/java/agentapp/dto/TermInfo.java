package agentapp.dto;

import java.util.Date;



public class TermInfo {

	private Date startDate;

	private Date endDate;

	private float price;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TermInfo [startDate=" + startDate + ", endDate=" + endDate + ", price=" + price + "]";
	}

}
