package custom.sunday.zbautotrade.base;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import custom.sunday.zbautotrade.utils.RxLife;
import io.reactivex.disposables.Disposable;

/**
 * @author apple
 * @decrption
 * @data 2019-05-23
 **/
public class BaseFragment extends Fragment implements RxLife {
    private List<Disposable> mRequestList = new ArrayList<>();
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNetworkErrorTips() {

    }

    @Override
    public void showTips(String msg) {

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


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        disposableAll();

    }
}
