package custom.sunday.zbautotrade.service;

import android.util.Log;

import custom.sunday.zbautotrade.RootBean;
import custom.sunday.zbautotrade.bean.CoinDepth;
import custom.sunday.zbautotrade.bean.Ticker;
import custom.sunday.zbautotrade.data.MarketZB;
import custom.sunday.zbautotrade.utils.OKHttpHelper;
import custom.sunday.zbautotrade.utils.RxUtil;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 行情接口
 * */
public class MarketService {

    private MarketZB marketZB;

    private MarketService(){

        Retrofit retrofit = new Retrofit.Builder()
                //设置数据解析器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                //设置网络请求的Url地址
                .client(OKHttpHelper.getInstance().getOkHttpClient())
                .baseUrl(MarketZB.BASE_URL)
                .build();

        marketZB = retrofit.create(MarketZB.class);
    }

    public static MarketService getInstance(){
        return Holder.Instance;
    }

    private static final class Holder{
        private static final MarketService Instance = new MarketService();
    }



    public Observable<RootBean<Ticker>> getTickerCoin(String coin){
        return marketZB.getMarketByCoin(coin).
                compose(RxUtil.<RootBean<Ticker>>applySchedulers());
    }

    public Observable<CoinDepth> getMarketDepthByCoin(String coin,
                                                      int size){
        return marketZB.getMarketDepthByCoin(coin,size).compose(RxUtil.<CoinDepth>applySchedulers());
    }




}

