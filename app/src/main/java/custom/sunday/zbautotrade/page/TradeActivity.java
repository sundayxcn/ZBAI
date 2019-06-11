package custom.sunday.zbautotrade.page;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import custom.sunday.zbautotrade.R;
import custom.sunday.zbautotrade.base.BaseActivity;
import custom.sunday.zbautotrade.data.AppFragmentAdapter;

public class TradeActivity extends BaseActivity {
    public static final String TAG = "TradeActivity";
    private ViewPager mViewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    protected void setupViews(){
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(new AppFragmentAdapter(getSupportFragmentManager()));
    }

    @Override
    protected void initWorks() {

    }

    @Override
    protected void onResume() {
        super.onResume();
//        MarketService.getInstance().getTickerCoin("btc_usdt").
//                subscribe(new RxUtil.SimpleObserver<RootBean<Ticker>>(this,"btc_usdt") {
//            @Override
//            public void onResult(RootBean<Ticker> tickerRootBean) {
//                Log.i(TAG,"tickerRootBean"+tickerRootBean);
//            }
//        });

//
//        MarketService.getInstance().getMarketDepthByCoin("btm_usdt",10).
//                subscribe(new RxUtil.SimpleObserver<CoinDepth>(this,"btm_usdt") {
//            @Override
//            public void onResult(CoinDepth coinDepth) {
//                Log.i(TAG,"coinDepth"+coinDepth);
//            }
//        });

    }
}
