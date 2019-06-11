package custom.sunday.zbautotrade.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author apple
 * @decrption
 * @data 2019-05-23
 **/
public class CoinUtil {

    public final List<String> mListCoin = new ArrayList<>();

    public static final String BTM = "btmusdt";
    public static final String BTC = "btcusdt";
    public static final String EOS = "eosusdt";


    private CoinUtil(){
        mListCoin.add(BTM);
        mListCoin.add(BTC);
        mListCoin.add(EOS);
    }

    public static CoinUtil getInstance(){
        return Holder.Instance;
    }

    private static final class Holder{
        private static final CoinUtil Instance = new CoinUtil();
    }


    public List<String> getAllCoin(){
        return mListCoin;
    }

}
