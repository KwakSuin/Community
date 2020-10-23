package kwaksuin.portfolio.community;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import kwaksuin.portfolio.community.board.FreeFragment;
import kwaksuin.portfolio.community.board.MarketFragment;
import kwaksuin.portfolio.community.board.PhotoFragment;
import kwaksuin.portfolio.community.board.QuestFragment;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home,container,false);
        return rootView;
    }

}