package models;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Repository;

import java.util.List;

public class User {

    private String login;
    private String avatar_url;
    private String url;
    private String name;
    private String company;
    private String location;
    private String email;
    private String bio;
    private String twitter_username;
    private String public_repos;
    private String followers;
    private String following;
    private String created_at;
    List<UserRepository> repositories;

    public List<UserRepository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<UserRepository> repositories) {
        this.repositories = repositories;
    }


    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTwitter_username() {
        return twitter_username;
    }

    public void setTwitter_username(String twitter_username) {
        this.twitter_username = twitter_username;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPublic_repos(String public_repos) {
        this.public_repos = public_repos;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public static User parseCommunityFromJSON(JsonNode userJSON) {
        User user = new User();

        user.login = userJSON.get("login").asText();
        user.avatar_url = userJSON.get("avatar_url").asText();
        user.url = userJSON.get("html_url").asText();
        user.name = userJSON.get("name").asText();
        user.location = userJSON.get("location").asText();
        user.email = userJSON.get("email").asText();
        user.twitter_username = userJSON.get("twitter_username").asText();
        user.public_repos = userJSON.get("public_repos").asText();
        user.followers = userJSON.get("followers").asText();
        user.following = userJSON.get("following").asText();
        user.created_at = userJSON.get("created_at").asText();
        user.company = userJSON.get("company").asText();
        user.bio = userJSON.get("bio").asText();

        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", twitter_username='" + twitter_username + '\'' +
                ", public_repos='" + public_repos + '\'' +
                ", followers='" + followers + '\'' +
                ", following='" + following + '\'' +
                ", created_at='" + created_at + '\'' +
                ", repositories=" + repositories +
                '}';
    }
}
