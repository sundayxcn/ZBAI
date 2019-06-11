package custom.sunday.zbautotrade.page.market;

import custom.sunday.zbautotrade.R;
import custom.sunday.zbautotrade.base.BaseActivity;

/**
 * @author apple
 * @decrption 从市场币种进入，显示K线图，5档数据，实时价格，交易记录
 * @data 2019-05-23
 **/
public class MarketDetailActivity extends BaseActivity {
    public static final String EXTRA_NAME = "name";
    @Override
    protected int getLayoutId() {
        return R.layout.activity_market_detail;
    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected void initWorks() {
        String name = getIntent().getStringExtra(EXTRA_NAME);
    }
}
