package custom.sunday.zbautotrade;

/**
 * @author apple
 * @decrption
 * @data 2019-05-23
 **/
public class RootBean<T> {
    String date;
    T ticker;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public T getTicker() {
        return ticker;
    }

    public void setTicker(T ticker) {
        this.ticker = ticker;
    }
}
