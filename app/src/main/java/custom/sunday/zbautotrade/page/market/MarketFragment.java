package custom.sunday.zbautotrade.page.market;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import custom.sunday.zbautotrade.R;
import custom.sunday.zbautotrade.base.BaseFragment;
import custom.sunday.zbautotrade.bean.Ticker;
import custom.sunday.zbautotrade.data.CoinListAdapter;
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
    private List<Ticker> mTickerList = new ArrayList<>();
    private CoinListAdapter mCoinListAdapter = new CoinListAdapter(mTickerList);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.layout_market, container, false);
        setupViews(view);
        return view;
    }

    private void setupViews(ViewGroup parent) {
        mCoinList = parent.findViewById(R.id.coin_list);
        mCoinList.setAdapter(mCoinListAdapter);
        mCoinList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ticker ticker = mTickerList.get(position);
                String name = ticker.getName();
                Intent intent = new Intent();
                intent.putExtra(MarketDetailActivity.EXTRA_NAME,name);
                intent.setClass(getContext(),MarketDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Observable.interval(1,5000, TimeUnit.MILLISECONDS).
                flatMap(new Function<Long, ObservableSource<List<Ticker>>>() {
                    @Override
                    public ObservableSource<List<Ticker>> apply(Long aLong) throws Exception {
                        return MarketService.getInstance().getTickerCoin();
                    }
                }).
                subscribe(new RxUtil.SimpleObserver<List<Ticker>>(this, "TickerCoin") {
                    @Override
                    public void onResult(List<Ticker> tickerList) {
                        mTickerList = tickerList;
                        mCoinListAdapter.changeData(tickerList);
                    }
                });
    }
}
