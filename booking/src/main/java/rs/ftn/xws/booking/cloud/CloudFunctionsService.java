package rs.ftn.xws.booking.cloud;

import java.util.List;

import rs.ftn.xws.booking.cloud.model.AccomodationRating;
import rs.ftn.xws.booking.cloud.model.AdminComment;
import rs.ftn.xws.booking.cloud.model.AgentComment;
import rs.ftn.xws.booking.cloud.model.Comment;
import rs.ftn.xws.booking.cloud.model.Rating;

public interface CloudFunctionsService {

	List<AccomodationRating> getRatings();

	void addRating(Rating rating) throws CloudFunctionException;

	List<AgentComment> getCommentsForAgent(String agent);

	List<Comment> getApprovedComments(Long accomodationId);

	List<AdminComment> getCommentsForReview();

	void approveComment(Long ratingId) throws CloudFunctionException;

	void declineComment(Long ratingId) throws CloudFunctionException;

}
