package custom.sunday.zbautotrade.bean;
/**
 * Auto-generated: 2019-05-23 10:30:1
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Ticker {

    private String name;

    //最高价
    private String high;
    //最低价
    private String low;
    //买一价
    private String buy;
    //卖一价
    private String sell;
    //成交量
    private String vol;

    private String last;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHigh(String high) {
        this.high = high;
    }
    public String getHigh() {
        return high;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }
    public String getVol() {
        return vol;
    }

    public void setLast(String last) {
        this.last = last;
    }
    public String getLast() {
        return last;
    }

    public void setLow(String low) {
        this.low = low;
    }
    public String getLow() {
        return low;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }
    public String getBuy() {
        return buy;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }
    public String getSell() {
        return sell;
    }

}