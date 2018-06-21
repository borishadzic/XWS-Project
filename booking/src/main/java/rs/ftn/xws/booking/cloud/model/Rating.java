package rs.ftn.xws.booking.cloud.model;

public class Rating {

	private Long accomodation;
	private String user;
	private Integer rating;
	private String comment;
	private String agent;
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Long accomodation) {
		this.accomodation = accomodation;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

}
