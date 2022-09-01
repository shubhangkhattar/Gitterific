package models;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Commit {

    private String sha;
    private String nodeId;
    private String commitMessage;
    private Long commentCount;
    private String commitUrl;
    private Long userId;
    private String userName;
    private String userEmail;
    private String userAvatar;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getCommitMessage() {
        return commitMessage;
    }

    public void setCommitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public String getCommitUrl() {
        return commitUrl;
    }

    public void setCommitUrl(String commitUrl) {
        this.commitUrl = commitUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        userAvatar = userAvatar;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public static Commit parseCommunityFromJSON(JsonNode commitJSON) {
        Commit commit = new Commit();

        commit.sha = commitJSON.get("sha").asText();
        commit.nodeId = commitJSON.get("node_id").asText();
        commit.commitMessage = commitJSON.get("commit").get("message").asText();
        commit.commentCount = commitJSON.get("commit").get("comment_count").asLong();
        commit.commitUrl = commitJSON.get("commit").get("url").asText();
        commit.userName = commitJSON.get("commit").get("author").get("name").asText();
        commit.userEmail = commitJSON.get("commit").get("author").get("email").asText();

        if(commitJSON.get("author").toString ().equals ("null")) {
            commit.userId = null;
            commit.userAvatar = "https://www.trustedclothes.com/blog/wp-content/uploads/2019/02/anonymous-person-221117.jpg";
        }
        else {
            commit.userId = commitJSON.get("author").get("id").asLong();
            commit.userAvatar = commitJSON.get("author").get("avatar_url").asText();
        }
        return commit;
    }

    public static LinkedHashMap<String, List<Commit>> getTopTenUserNameWithCommits(List<Commit> commits) {
        return commits.stream()
                .collect(Collectors.groupingBy(c-> c.getUserName ()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().size () - e1.getValue().size () ).limit (10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    @Override
    public String toString() {
        return "Commit{" +
                "sha='" + sha + '\'' +
                ", nodeId='" + nodeId + '\'' +
                ", commitMessage='" + commitMessage + '\'' +
                ", commentCount=" + commentCount +
                ", commitUrl='" + commitUrl + '\'' +
                ", UserId=" + userId +
                ", UserName='" + userName + '\'' +
                ", UserAvatar='" + userAvatar + '\'' +
                '}';
    }
}
