package agentapp.dto;

public class MessageInfo {
	
	private String message;
	private Long termId;
	private String userId;
	
	public MessageInfo() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTermId() {
		return termId;
	}

	public void setTermId(Long termId) {
		this.termId = termId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "MessageInfo [message=" + message + ", termId=" + termId + ", userId=" + userId + "]";
	}
	
}
