package rs.ftn.xws.booking.cloud;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;

import rs.ftn.xws.booking.cloud.model.AccomodationRating;
import rs.ftn.xws.booking.cloud.model.AdminComment;
import rs.ftn.xws.booking.cloud.model.AgentComment;
import rs.ftn.xws.booking.cloud.model.Comment;
import rs.ftn.xws.booking.cloud.model.Rating;

@Service
public class CloudFunctionServiceImpl implements CloudFunctionsService {

	private final CloudConfig cloudConfig;
	private final RestTemplate restTemplate = new RestTemplate();

	public CloudFunctionServiceImpl(CloudConfig cloudConfig) {
		this.cloudConfig = cloudConfig;
	}

	@Override
	public List<AccomodationRating> getRatings() {
		return Arrays.asList(restTemplate.getForObject(cloudConfig.getGetRatings(), AccomodationRating[].class));
	}

	@Override
	public void addRating(Rating rating) throws CloudFunctionException {
		HttpEntity<Rating> request = new HttpEntity<Rating>(rating);
		ResponseEntity<String> response = restTemplate.postForEntity(cloudConfig.getPostRating(), request,
				String.class);

		if (response.getStatusCode() != HttpStatus.OK) {
			throw new CloudFunctionException("Error while submiting rating.");
		}
	}

	@Override
	public List<AgentComment> getCommentsForAgent(String agent) {
		String url = cloudConfig.getGetCommentsForAgent() + "?agent={agent}";
		  URI expanded = new UriTemplate(url).expand(agent);

		  return Arrays.asList(restTemplate.getForObject(expanded, AgentComment[].class));
	}

	@Override
	public List<Comment> getApprovedComments(Long accomodationId) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(cloudConfig.getGetApprovedComments())
				.queryParam("accomodation", accomodationId);

		return Arrays.asList(restTemplate.getForObject(builder.toUriString(), Comment[].class));
	}

	@Override
	public List<AdminComment> getCommentsForReview() {
		return Arrays.asList(restTemplate.getForObject(cloudConfig.getGetCommentsForReview(), AdminComment[].class));
	}

	@Override
	public void approveComment(Long ratingId) throws CloudFunctionException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(cloudConfig.getApproveComment())
				.queryParam("id", ratingId);

		HttpEntity<Void> entity = new HttpEntity<Void>(new HttpHeaders());

		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity,
				String.class);

		if (response.getStatusCode() != HttpStatus.OK) {
			throw new CloudFunctionException("An error has occured while approving comment");
		}
	}

	@Override
	public void declineComment(Long ratingId) throws CloudFunctionException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(cloudConfig.getDeclineComment())
				.queryParam("id", ratingId);

		HttpEntity<Void> entity = new HttpEntity<Void>(new HttpHeaders());

		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity,
				String.class);

		if (response.getStatusCode() != HttpStatus.OK) {
			throw new CloudFunctionException("An error has occured while approving comment");
		}
	}

}
