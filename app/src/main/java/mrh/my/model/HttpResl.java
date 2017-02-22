package mrh.my.model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import mrh.my.model.bean.BeseTou;
import mrh.my.model.interefaces.ApiSever;
import mrh.my.utils.url.Api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * autour: 韓文瑞
 * date: 2017/2/22 0022
 * update: 2017/2/22 0022
 */

public class HttpResl {


    public static HttpResl mHttpResl;
    public ApiSever mApiSever;
    public Retrofit mRetrofit;

    //单例
    public HttpResl(){

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Api.Bese)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiSever = mRetrofit.create(ApiSever.class);

    }

    //返回本类对象
    public static HttpResl getRequst(){

        if(mHttpResl==null){

            synchronized (HttpResl.class){
                if(mHttpResl==null){

                    mHttpResl=new HttpResl();
                }
            }
        }

       return mHttpResl ;

    }


    public <T> void RetrofitQuest (Observable<BeseTou<T>> observable, final Observer<T> observer){

        observable.map(new Function<BeseTou<T>, T>() {

            @Override
            public T apply(BeseTou<T> tou) throws Exception {
                return tou.resultss;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

}
