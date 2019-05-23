package custom.sunday.zbautotrade.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import custom.sunday.zbautotrade.R;
import custom.sunday.zbautotrade.RootBean;
import custom.sunday.zbautotrade.base.BaseFragment;
import custom.sunday.zbautotrade.bean.Ticker;
import custom.sunday.zbautotrade.data.CoinListAdapter;
import custom.sunday.zbautotrade.service.MarketService;
import custom.sunday.zbautotrade.utils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * @author apple
 * @decrption
 * @data 2019-05-23
 **/
public class MarketFragment extends BaseFragment {
    public static final String TAG = "MarketFragment";
    private ListView mCoinList;
    private int coinCount = 1;
    private List<Ticker> mTickerList = new ArrayList<>();
    private CoinListAdapter mCoinListAdapter = new CoinListAdapter(mTickerList);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.layout_market,container,false);
        setupViews(view);
        return view;
    }

    private void setupViews(ViewGroup parent){
        mCoinList = parent.findViewById(R.id.coin_list);
        mCoinList.setAdapter(mCoinListAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Observable.interval(5000, TimeUnit.MILLISECONDS).
                flatMap(new Function<Long, ObservableSource<RootBean<Ticker>>>() {
            @Override
            public ObservableSource<RootBean<Ticker>> apply(Long aLong) throws Exception {
                return MarketService.getInstance().getTickerCoin("btc_usdt");
            }
        }).
            subscribe(new RxUtil.SimpleObserver<RootBean<Ticker>>(this, "btc_usdt") {
                @Override
                public void onResult(RootBean<Ticker> tickerRootBean) {
                    Ticker ticker = tickerRootBean.getTicker();
                    ticker.setName("btc_usdt");
                    List<Ticker> tickers = new ArrayList<>();
                    tickers.add(ticker);
                    mCoinListAdapter.changeData(tickers);
                }
            });
    }
}
