package con.modhe.uncash.utils;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * author Created by harrishuang on 2020-09-10.
 * email : huangjinping1000@163.com
 */
public interface GitHubService {
    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);
}
