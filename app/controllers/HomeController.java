package controllers;

import models.Commit;
import models.User;

import models.RepoProfile;
import play.mvc.Http.Request;
import play.mvc.*;
import services.GitHubAPIService;
import views.html.commit;
import views.html.user;
import views.html.repoprofile;

import javax.inject.Inject;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * This home controller contains an action to handle HTTP requests,
 *  to the application's home page.
 */

public class HomeController extends Controller {

    @Inject
    GitHubAPIService gitHubAPIService;

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result commits(String org, String repo) throws ExecutionException, InterruptedException, IOException {
        List<Commit> commits = gitHubAPIService.getRepositoryCommits(org, repo);
        LinkedHashMap<String, List<Commit>> userCommitMap = Commit.getTopTenUserNameWithCommits(commits);
        return ok(commit.render(userCommitMap));
    }

    public Result users(String name) throws ExecutionException, InterruptedException, IOException {
        User usr = gitHubAPIService.getUser(name);
        return ok(user.render(usr));
    }

    
	/**
	 * The below repoprofile action renders a HTML page containing Repository details, 
	 * top 20 issues and contributers list.
	 * The configuration in the <code>routes</code> file means that
	 * this method will be called when the application receives a
	 * <code>GET</code> request with a path of <code>/</code>.
	 */
    
    public Result repoprofile(String org, String repo) throws ExecutionException, InterruptedException, IOException {
        RepoProfile repoproFile = gitHubAPIService.getRepositoryProfile(org, repo);
        return ok(repoprofile.render(repoproFile));
    }
    
}






