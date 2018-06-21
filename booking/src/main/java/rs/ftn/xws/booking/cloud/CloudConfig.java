package rs.ftn.xws.booking.cloud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cloud.api")
public class CloudConfig {

	private String getRatings;
	private String postRating;
	private String getCommentsForAgent;
	private String getApprovedComments;
	private String getCommentsForReview;
	private String approveComment;
	private String declineComment;

	public String getGetRatings() {
		return getRatings;
	}

	public void setGetRatings(String getRatings) {
		this.getRatings = getRatings;
	}

	public String getPostRating() {
		return postRating;
	}

	public void setPostRating(String postRating) {
		this.postRating = postRating;
	}

	public String getGetCommentsForAgent() {
		return getCommentsForAgent;
	}

	public void setGetCommentsForAgent(String getCommentsForAgent) {
		this.getCommentsForAgent = getCommentsForAgent;
	}

	public String getGetApprovedComments() {
		return getApprovedComments;
	}

	public void setGetApprovedComments(String getApprovedComments) {
		this.getApprovedComments = getApprovedComments;
	}

	public String getGetCommentsForReview() {
		return getCommentsForReview;
	}

	public void setGetCommentsForReview(String getCommentsForReview) {
		this.getCommentsForReview = getCommentsForReview;
	}

	public String getApproveComment() {
		return approveComment;
	}

	public void setApproveComment(String approveComment) {
		this.approveComment = approveComment;
	}

	public String getDeclineComment() {
		return declineComment;
	}

	public void setDeclineComment(String declineComment) {
		this.declineComment = declineComment;
	}

}
