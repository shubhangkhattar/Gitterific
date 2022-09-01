package models;

/**
 * @author Sivakumaran Janardhanan on 11-10-2021 (MM/DD/YYYY)
 * @project Gitterific
 */

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Model to store the Issues present in a GitHub Repository
 * 
 */

public class Issues {
	/**
	 * Initialization of all variables to be used/retrieved from API call
	 */

	private String issue_owner;
	private String issue_title;
	private Long comments;

	/**
	 * Get owner name of the issue
	 * 
	 * @return issue_owner
	 */

	public String getIssue_owner() {
		return issue_owner;
	}

	/**
	 * Set onwer name of the issue from API call
	 * 
	 * @param issue_owner
	 */

	public void setIssue_owner(String issue_owner) {
		this.issue_owner = issue_owner;
	}

	/**
	 * Get issue title
	 * 
	 * @return issue_title
	 */

	public String getIssue_title() {
		return issue_title;
	}

	/**
	 * Set issue title from API call
	 * 
	 * @param issue_title
	 */

	public void setIssue_title(String issue_title) {
		this.issue_title = issue_title;
	}

	/**
	 * get number of comments for each issue
	 * 
	 * @return comments
	 */

	public Long getComments() {
		return comments;
	}

	/**
	 * Set number of comments for each issue from API call
	 * 
	 * @param comments
	 */

	public void setComments(Long comments) {
		this.comments = comments;
	}

	/**
	 * Method to parse the JSON output to usable format
	 * 
	 * @param repositoryJSON
	 * @return issue
	 */

	public static Issues parseRepositoryFromJSON(JsonNode repositoryJSON) {
		Issues issue = new Issues();

		issue.issue_owner = repositoryJSON.get("user").get("login").asText();
		issue.issue_title = repositoryJSON.get("title").asText();
		issue.comments = repositoryJSON.get("comments").asLong();

		return issue;

	}

	/**
	 * List method to stream the list and limit the results to 20
	 * 
	 * @param issues
	 * @return streamed and limited issue list
	 */
	public static List<Issues> getTopTwentyIssues(List<Issues> issues) {
		return issues.stream().limit(20).collect(Collectors.toList());

	}

	/**
	 * toString() method used for debug purposes.
	 */

	@Override
	public String toString() {
		return "Issues [issue_owner=" + issue_owner + ", issue_title=" + issue_title + ", comments=" + comments + "]";
	}
}
