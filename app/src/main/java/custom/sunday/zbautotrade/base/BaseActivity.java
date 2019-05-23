package custom.sunday.zbautotrade.base;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import custom.sunday.zbautotrade.utils.RxLife;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhongfei.sun on 2018/1/17.
 */

public class BaseActivity extends FragmentActivity implements RxLife {

    private List<Disposable> mRequestList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNetworkErrorTips() {
        showTips("网络错误");
    }

    @Override
    public void addDisposable(Disposable disposable) {
        mRequestList.add(disposable);
    }

    @Override
    public void removeDisposable(Disposable disposable) {
        mRequestList.remove(disposable);
    }

    @Override
    public void disposableAll() {
        for(Disposable disposable:mRequestList){
            if(!disposable.isDisposed()){
                disposable.dispose();
            }
        }
        mRequestList.clear();
    }

    public void showTips(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        disposableAll();
    }
}
