package models;

/**
 * @author Sivakumaran Janardhanan on 11-10-2021 (MM/DD/YYYY)
 * @project Gitterific
 */

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Model to store Contributers data .
 */
public class Contributers {

	/**
	 * Initialization of all variables to be used/retrieved from API call
	 */
	
	private String name;
	private String avatar_url;
	private String contributions_count;
	
	/**
	 * Gets the Contributer's name
	 * @return name
	 */

	public String getName() {
		return name;
	}
	/**
	 * Sets the name retrieved from API call
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the Contributer's Avatar image link
	 * @return avatar_url
	 */

	public String getAvatar_url() {
		return avatar_url;
	}
	/**
	 * Sets the Contributer Avatar image link from API call
	 * @param avatar_url
	 */

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	/**
	 * Gets the number of contributions done
	 * @return contributions_count
	 */

	public String getContributions_count() {
		return contributions_count;
	}
	/**
	 * Sets the number of contributions done from API call
	 * @param contributions_count
	 */

	public void setContributions_count(String contributions_count) {
		this.contributions_count = contributions_count;
	}
	
	/**
	 * Method to parse the JSON output to usable format
	 * @param repositoryJSON
	 * @return contributer
	 */

	public static Contributers parseRepositoryFromJSON(JsonNode repositoryJSON) {
		Contributers contributer = new Contributers();

		contributer.name = repositoryJSON.get("login").asText();
		contributer.avatar_url = repositoryJSON.get("avatar_url").asText();
		contributer.contributions_count = repositoryJSON.get("contributions").asText();

		return contributer;
	}

	/**
	 * toString() method used for debug purposes.
	 */

	@Override
	public String toString() {
		return "Contributers [name=" + name + ", avatar_url=" + avatar_url + ", contributions_count="
				+ contributions_count + "]";
	}

}
