package custom.sunday.zbautotrade.bean;

import java.util.List;

/**
 * @author apple
 * @decrption
 * @data 2019-05-23
 **/
public class CoinDepth {

    private List<List<Double>> asks;
    private List<List<Double>> bids;
    private long timestamp;
    public void setAsks(List<List<Double>> asks) {
        this.asks = asks;
    }
    public List<List<Double>> getAsks() {
        return asks;
    }

    public void setBids(List<List<Double>> bids) {
        this.bids = bids;
    }
    public List<List<Double>> getBids() {
        return bids;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public long getTimestamp() {
        return timestamp;
    }

}