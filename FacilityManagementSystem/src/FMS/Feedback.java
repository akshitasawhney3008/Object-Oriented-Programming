package FMS;

public class Feedback {
	private int complaintid;
	private String userid;
	private String feedback;
	private int rating;
	
	public Feedback(int complaintid, String userid, String feedback, int rating) {
		this.complaintid = complaintid;
		this.userid = userid;
		this.feedback = feedback;
		this.rating = rating;
	}

	public int getComplaintid() {
		return complaintid;
	}

	public void setComplaintid(int complaintid) {
		this.complaintid = complaintid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
