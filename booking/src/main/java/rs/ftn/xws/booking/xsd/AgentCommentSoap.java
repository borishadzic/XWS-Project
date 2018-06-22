package rs.ftn.xws.booking.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class AgentCommentSoap {
	
	@XmlElement
	private Long accomodationId;
	
	@XmlElement
	private String comment;
	
	@XmlElement
	private String userId;
	
	@XmlElement
	private Integer rating;

	public Long getAccomodationId() {
		return accomodationId;
	}

	public void setAccomodationId(Long accomodationId) {
		this.accomodationId = accomodationId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
