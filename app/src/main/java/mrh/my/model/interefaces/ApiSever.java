package mrh.my.model.interefaces;

import io.reactivex.Observable;
import mrh.my.model.bean.BeseTou;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * autour: 韓文瑞
 * date: 2017/2/22 0022
 * update: 2017/2/22 0022
 */

public interface ApiSever {
    @GET("thailand/fm")
    Observable<BeseTou> getBese(@Query("key")String key);
}
