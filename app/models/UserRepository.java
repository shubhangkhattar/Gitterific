package models;

import com.fasterxml.jackson.databind.JsonNode;

public class UserRepository {

    private String name;
    private String html_url;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }


    public static UserRepository parseRepositoryFromJSON(JsonNode repositoryJSON) {
        UserRepository repository = new UserRepository();

        repository.name = repositoryJSON.get("name").asText();
        repository.html_url = repositoryJSON.get("html_url").asText();
        repository.description = repositoryJSON.get("description").asText();
        return repository;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "name='" + name + '\'' +
                ", html_url='" + html_url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
