package custom.sunday.zbautotrade.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import custom.sunday.zbautotrade.R;
import custom.sunday.zbautotrade.bean.Ticker;

/**
 * @author apple
 * @decrption
 * @data 2019-05-23
 **/

public class CoinListAdapter extends BaseAdapter {

    private List<Ticker> mTickerList;

    public CoinListAdapter(List<Ticker> tickerList){
        mTickerList = tickerList;
    }


    public void changeData(List<Ticker> tickerList){
        mTickerList.clear();
        mTickerList.addAll(tickerList);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mTickerList.size();
    }

    @Override
    public Ticker getItem(int position) {
        return mTickerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_market_coin,null,false);
            convertView.setTag(new Holder(convertView));
        }
        Holder holder = (Holder) convertView.getTag();
        Ticker ticker = mTickerList.get(position);
        holder.nameView.setText(ticker.getName());
        holder.priceView.setText(ticker.getBuy());

        return convertView;
    }


    public static class Holder{
        public TextView nameView;
        public TextView priceView;
        public TextView riseView;

        public Holder(View parent){
            nameView = parent.findViewById(R.id.name);
            priceView = parent.findViewById(R.id.price);
            riseView = parent.findViewById(R.id.rise);
        }



    }

}
