package custom.sunday.zbautotrade.data;

import custom.sunday.zbautotrade.bean.RootBean;
import custom.sunday.zbautotrade.bean.CoinDepth;
import custom.sunday.zbautotrade.bean.Ticker;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarketZB {
     String BASE_URL = "http://api.zb.cn/data/v1/";


    @GET("allTicker")
    Observable<ResponseBody> getMarketAllCoin();


    //http://api.zb.cn/data/v1/ticker?market=btc_usdt
    @GET("ticker")
    Observable<RootBean<Ticker>> getMarketByCoin(@Query("market") String coin);


    //http://api.zb.cn/data/v1/depth?market=btc_usdt&size=10
    @GET("depth")
    Observable<CoinDepth> getMarketDepthByCoin(@Query("market") String coin,
                                               @Query("size") int size);

}
