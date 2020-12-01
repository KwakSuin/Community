package kwaksuin.portfolio.community.board.market;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kwaksuin.portfolio.community.R;

public class MarketFragment extends Fragment {

    MarketList marketlist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_market,container,false);

        marketlist = new MarketList();
        getFragmentManager().beginTransaction().replace(R.id.market_container, marketlist).commit();

        return rootView;
    }
}