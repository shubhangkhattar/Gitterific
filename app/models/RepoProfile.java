package models;

/**
 * @author Sivakumaran Janardhanan on 11-10-2021 (MM/DD/YYYY)
 * @project Gitterific
 */

import com.fasterxml.jackson.databind.JsonNode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Model to store the repository profile details
 * 
 */

public class RepoProfile {
	/**
	 * Initialization of all variables to be used/retrieved from API call
	 */

	private String name;
	private String full_name;
	private String owner_name;
	private String owner_avatar_url;
	private String url;
	private String description;
	private String branches_url;
	private String created_at;
	private String last_updated_at;
	private Long watchers_count;
	private Long open_issues_count;
	private Long forks_count;
	private Long subscribers_count;
	List<Contributers> contributers;
	List<Issues> issues;

	/**
	 * Get the list of objects present from Issues.Java class
	 * 
	 * @return issues
	 */

	public List<Issues> getIssues() {
		return issues;
	}

	/**
	 * Sets the list of object retrieved from the API call into each object of
	 * Issues.java class
	 * 
	 * @param issues
	 */

	public void setIssues(List<Issues> issues) {
		this.issues = issues;
	}

	/**
	 * Get the list of objects present from contributers.Java class
	 * 
	 * @return contributers
	 */

	public List<Contributers> getContributers() {
		return contributers;
	}

	/**
	 * Sets the list of object retrieved from the API call into each object of
	 * Contributers.java class
	 * 
	 * @param issues
	 */

	public void setContributers(List<Contributers> contributers) {
		this.contributers = contributers;
	}

	/**
	 * Gets the name of the repository
	 * 
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the repository from API call
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the full name of the repository including organization name, which will
	 * further be used for calling commits page
	 * 
	 * @return full_name
	 */

	public String getFull_name() {
		return full_name;
	}

	/**
	 * Sets the full name of the repository from API call
	 * 
	 * @param full_name
	 */

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	/**
	 * Gets the repository owner name
	 * 
	 * @return
	 */

	public String getOwner_name() {
		return owner_name;
	}

	/**
	 * Sets the repository owner name from API call
	 * 
	 * @param owner_name
	 */

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	/**
	 * Gets the repository's owners avatar URL
	 * 
	 * @return owner_avatar_url
	 */

	public String getOwner_avatar_url() {
		return owner_avatar_url;
	}

	/**
	 * Sets the repository's owners avatar URL from API call
	 * 
	 * @param owner_avatar_url
	 */

	public void setOwner_avatar_url(String owner_avatar_url) {
		this.owner_avatar_url = owner_avatar_url;
	}

	/**
	 * Gets the URL of the repository
	 * 
	 * @return
	 */

	public String getUrl() {
		return url;
	}

	/**
	 * Sets the URL of the repository from API call
	 * 
	 * @param url
	 */

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the description of the repository from API call
	 * 
	 * @return description
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the repository from API call
	 * 
	 * @param description
	 */

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the branch URL of the repository
	 * 
	 * @return branches_url
	 */

	public String getBranches_url() {
		return branches_url;
	}

	/**
	 * Sets the branch URL of the repository from API call
	 * 
	 * @param branches_url
	 */

	public void setBranches_url(String branches_url) {
		this.branches_url = branches_url;
	}

	/**
	 * Gets the repository created date
	 * 
	 * @return created_at
	 */

	public String getCreated_at() {
		return created_at;
	}

	/**
	 * Sets the repository create date from API call
	 * 
	 * @param created_at
	 */

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	/**
	 * Gets the repository last updated date
	 * 
	 * @return last_updated_at
	 */

	public String getLast_updated_at() {
		return last_updated_at;
	}

	/**
	 * Sets the repository last updated date from API call
	 * 
	 * @param last_updated_at
	 */

	public void setLast_updated_at(String last_updated_at) {
		this.last_updated_at = last_updated_at;
	}

	/**
	 * Gets the count of watchers
	 * 
	 * @return watchers_count
	 */

	public Long getWatchers_count() {
		return watchers_count;
	}

	/**
	 * Sets the count of watchers from API call
	 * 
	 * @param watchers_count
	 */

	public void setWatchers_count(Long watchers_count) {
		this.watchers_count = watchers_count;
	}

	/**
	 * Gets the open issue count
	 * 
	 * @return open_issues_count
	 */

	public Long getOpen_issues_count() {
		return open_issues_count;
	}

	/**
	 * Sets the open issues count from API call
	 * 
	 * @param open_issues_count
	 */

	public void setOpen_issues_count(Long open_issues_count) {
		this.open_issues_count = open_issues_count;
	}

	/**
	 * Gets the fork count
	 * 
	 * @return forks_count
	 */

	public Long getForks_count() {
		return forks_count;
	}

	/**
	 * Sets the fork count from API call
	 * 
	 * @param forks_count
	 */

	public void setForks_count(Long forks_count) {
		this.forks_count = forks_count;
	}

	/**
	 * Gets the subscribers count
	 * 
	 * @return subscribers_count
	 */

	public Long getSubscribers_count() {
		return subscribers_count;
	}

	/**
	 * Sets the subscribers count from API call
	 * 
	 * @param subscribers_count
	 */

	public void setSubscribers_count(Long subscribers_count) {
		this.subscribers_count = subscribers_count;
	}

	/**
	 * Method to parse the JSON output to usable format
	 * 
	 * @param userJSON
	 * @return repoprofile
	 */

	public static RepoProfile parseCommunityFromJSON(JsonNode userJSON) {
		RepoProfile repoprofile = new RepoProfile();

		repoprofile.name = userJSON.get("name").asText();
		repoprofile.full_name = userJSON.get("full_name").asText();
		repoprofile.owner_name = userJSON.get("owner").get("login").asText();
		repoprofile.owner_avatar_url = userJSON.get("owner").get("avatar_url").asText();
		repoprofile.url = userJSON.get("html_url").asText();
		repoprofile.description = userJSON.get("description").asText();
		repoprofile.branches_url = userJSON.get("branches_url").asText();
		repoprofile.created_at = userJSON.get("created_at").asText();
		repoprofile.last_updated_at = userJSON.get("updated_at").asText();
		repoprofile.created_at = userJSON.get("created_at").asText();
		repoprofile.watchers_count = userJSON.get("watchers_count").asLong();
		repoprofile.open_issues_count = userJSON.get("open_issues_count").asLong();
		repoprofile.forks_count = userJSON.get("forks").asLong();
		repoprofile.subscribers_count = userJSON.get("subscribers_count").asLong();

		return repoprofile;
	}

	/**
	 * toString() method used for debug purposes.
	 */

	@Override
	public String toString() {
		return "RepoProfile [name=" + name + ", full_name=" + full_name + ", owner_name=" + owner_name
				+ ", owner_avatar_url=" + owner_avatar_url + ", url=" + url + ", description=" + description
				+ ", branches_url=" + branches_url + ", created_at=" + created_at + ", last_updated_at="
				+ last_updated_at + ", watchers_count=" + watchers_count + ", open_issues_count=" + open_issues_count
				+ ", forks_count=" + forks_count + ", subscribers_count=" + subscribers_count + "]";
	}

}
