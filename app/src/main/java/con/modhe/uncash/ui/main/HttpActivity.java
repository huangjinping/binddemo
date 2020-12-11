package con.modhe.uncash.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import con.modhe.uncash.R;
import con.modhe.uncash.utils.GitHubService;
import con.modhe.uncash.utils.Repo;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * author Created by harrishuang on 2020-09-10.
 * email : huangjinping1000@163.com
 */
public class HttpActivity extends AppCompatActivity {

    String url = "https://ic.daiyutech.com/hd-merchant-web/mobile/index";
    OkHttpClient client = new OkHttpClient();


    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        onPost(getWindow().getDecorView());
    }

    public void onGet(View view) {
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                Log.d("okhttp", "=== =onGet             ==1");
//                String run = run(url);
//                Log.d("okhttp", "=== =onGet             ==2");
//                emitter.onNext(run);
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                Log.d("okhttp", "=== =onGet        response     ==" + s);
//                System.out.println(s);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d("okhttp", "==onGet==" + e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//            }
//        });


        OkHttpUtils
                .get()
                .url("")
                .addParams("", "")
                .addParams("", "")
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

            }
        });
    }


    String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


    public void onPost(View view) {
//        NetWorkManager.getInstance().init();
//        io.reactivex.disposables.Disposable disposable = NetWorkManager.getRequest().getList("xxxxxx")
//                .compose(ResponseTransformer.handleResult())
//                .compose(SchedulerProvider.getInstance().applySchedulers())
//                .subscribe(carBeans -> {
//                    // 处理数据 直接获取到List<JavaBean> carBeans
//                }, throwable -> {
//                    // 处理异常
//                });
        /**
         * 定的
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Observable<List<Repo>> repos = service.listRepos("octocat");
        repos.subscribe(new Observer<List<Repo>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("okhttp", "================onSubscribe==============");
            }

            @Override
            public void onNext(@NonNull List<Repo> repos) {
                Log.d("okhttp", repos.toString());
                Log.d("okhttp", "==============================");
                Log.d("okhttp", "====currentThread====" + Thread.currentThread().getName());
                Log.d("okhttp", "==============================");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("okhttp", "================onError==============");
            }

            @Override
            public void onComplete() {
                Log.d("okhttp", "================onComplete==============");
            }
        });
//        repos.enqueue(new Callback<List<Repo>>() {
//            @Override
//            public void onResponse(Call<List<Repo>> call, retrofit2.Response<List<Repo>> response) {
//                Log.d("okhttp", "==============================");
//                Log.d("okhttp", response.body().toString());
//                Log.d("okhttp", "==============================");
//            }
//
//            @Override
//            public void onFailure(Call<List<Repo>> call, Throwable t) {
//            }
//        });


//        Toast.makeText(this, "onPost", Toast.LENGTH_SHORT).show();
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
//                String json = "{\n" +
//                        "  \"name\": \"docker\",\n" +
//                        "  \"location\": \"天安门\"\n" +
//                        "}";
//                RequestBody body = RequestBody.create(JSON, json);
//                Log.d("okhttp", "=== =onPost             ==1");
//                Request request = new Request.Builder()
//                        .url(url)
//                        .post(body)
//                        .build();
//                Log.d("okhttp", "=== =onPost             ==2");
//                Response response = client.newCall(request).execute();
//                Log.d("okhttp", "=== =onPost             =3");
//                emitter.onNext(response.body().string());
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                Log.d("okhttp", "=== =onPost        response     ==" + s);
//                System.out.println(s);
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d("okhttp", "==onPost==" + e.getMessage());
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

    }
}
