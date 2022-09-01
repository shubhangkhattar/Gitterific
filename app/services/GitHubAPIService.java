package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.Commit;
import models.UserRepository;
import models.User;

import models.Contributers;
import models.Issues;
import models.RepoProfile;
import play.libs.Json;
import play.libs.ws.WSClient;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class GitHubAPIService {

    @Inject
    WSClient ws;

    String url = "https://api.github.com/";

    public List<Commit> getRepositoryCommits(String org, String repo) throws ExecutionException, InterruptedException {
        CompletableFuture<JsonNode> jsonNode = ws.url(this.url + "repos/" + org + "/" + repo + "/commits?per_page=100")
                .get()
                .thenApply(r -> r.getBody())
                .thenApply(j -> Json.parse(j)).toCompletableFuture();

        List<Commit> commits = new ArrayList<Commit>();
        for (JsonNode comm : jsonNode.get()) {
            Commit community = Commit.parseCommunityFromJSON(comm);
            commits.add(community);
        }
        return commits;
    }

    public User getUser(String name) throws ExecutionException, InterruptedException {
        CompletableFuture<JsonNode> jsonNodeUser = ws.url(this.url + "users/" + name)
                .get()
                .thenApply(r -> r.getBody())
                .thenApply(j -> Json.parse(j)).toCompletableFuture();

        CompletableFuture<JsonNode> jsonNodeRepo = ws.url(this.url + "users/" + name + "/repos")
                .get()
                .thenApply(r -> r.getBody())
                .thenApply(j -> Json.parse(j)).toCompletableFuture();

        User user = User.parseCommunityFromJSON(jsonNodeUser.get());

        List<UserRepository> repositories = new ArrayList<UserRepository>();

        for (JsonNode rep : jsonNodeRepo.get()) {
            UserRepository repo = UserRepository.parseRepositoryFromJSON(rep);
            repositories.add(repo);
        }

        user.setRepositories(repositories);

        return user;
    }


    
    /**
     * Method to create an API call to Github and retrieve/handle the Json output
     * This method is used only for Repository profile
     * @author Sivakumaran Janardhanan on 11-10-2021 (MM/DD/YYYY)
     * @param org
     * @param repo
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public RepoProfile getRepositoryProfile(String org, String repo) throws InterruptedException, ExecutionException{
        CompletableFuture<JsonNode> jsonNoderepoprof = ws.url (this.url + "repos/" + org + "/" + repo)
                .get ()
                .thenApply (r->r.getBody ())
                .thenApply (j -> Json.parse(j)).toCompletableFuture();
        
        CompletableFuture<JsonNode> jsonNodecontributers = ws.url (this.url + "repos/" + org + "/" + repo + "/contributors")
                .get ()
                .thenApply (r->r.getBody ())
                .thenApply (j -> Json.parse(j)).toCompletableFuture();
        
        CompletableFuture<JsonNode> jsonNodeissues = ws.url (this.url + "repos/" + org + "/" + repo + "/issues")
                .get ()
                .thenApply (r->r.getBody ())
                .thenApply (j -> Json.parse(j)).toCompletableFuture();
        
                     
        RepoProfile repProfile = RepoProfile.parseCommunityFromJSON(jsonNoderepoprof.get());
        //System.out.println(repProfile);    
        
        List<Contributers> contri = new ArrayList<Contributers>();
        for (JsonNode contrib : jsonNodecontributers.get()) {
        	Contributers cont = Contributers.parseRepositoryFromJSON(contrib);
        	contri.add(cont);
        }
        repProfile.setContributers(contri);
        
        List<Issues> issue = new ArrayList<Issues>();
        for (JsonNode issueJson : jsonNodeissues.get()) {
        	Issues iss = Issues.parseRepositoryFromJSON(issueJson);
        	issue.add(iss);
        }
        
        repProfile.setIssues(Issues.getTopTwentyIssues(issue));
        
        
        return repProfile;
    }
}



















