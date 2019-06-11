package custom.sunday.zbautotrade.page.market;



import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import custom.sunday.zbautotrade.bean.RootBean;
import custom.sunday.zbautotrade.bean.CoinDepth;
import custom.sunday.zbautotrade.bean.Ticker;
import custom.sunday.zbautotrade.data.MarketZB;
import custom.sunday.zbautotrade.utils.CoinUtil;
import custom.sunday.zbautotrade.utils.OKHttpHelper;
import custom.sunday.zbautotrade.utils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;
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



    /**
     * 获取所有监控的币种行情
     * **/
    public Observable<List<Ticker>> getTickerCoin(){
        return marketZB.getMarketAllCoin().
                map(new Function<ResponseBody, List<Ticker>>() {
            @Override
            public List<Ticker> apply(ResponseBody responseBody) throws Exception {
                String response = responseBody.string();
                List<String> nameList = CoinUtil.getInstance().getAllCoin();
                JSONObject jsonObject = new JSONObject(response);
                List<Ticker> tickerList = new ArrayList<>();
                Gson gson = new Gson();
                for(String name : nameList){
                    String object = jsonObject.optJSONObject(name).toString();
                    Ticker ticker = gson.fromJson(object,Ticker.class);
                    ticker.setName(name);
                    tickerList.add(ticker);
                }
                return tickerList;
            }
        }).compose(RxUtil.<List<Ticker>>applySchedulers());
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

