package mrh.my.model;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * autour: 韓文瑞
 * date: 2017/2/22 0022
 * update: 2017/2/22 0022
 */

public abstract class Can <T> implements Observer<T> {
    @Override
    public void onComplete() {
        Log.d("TTT", "请求后");
    }

    @Override
    public void onError(Throwable e) {
        Log.d("TTT", "失败");
    }

    @Override
    public void onNext(T t) {
        Log.d("TTT", "成功");
        onNextTo(t);
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d("TTT", "请求前");
    }
    // 回调用于加载数据的接口
    public abstract void onNextTo(T t);

}
