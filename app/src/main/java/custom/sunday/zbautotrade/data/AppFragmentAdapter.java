package custom.sunday.zbautotrade.data;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import custom.sunday.zbautotrade.page.market.MarketFragment;

/**
 * @author apple
 * @decrption
 * @data 2019-05-23
 **/
public class AppFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    public AppFragmentAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new MarketFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
