package kwaksuin.portfolio.community.board.photo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kwaksuin.portfolio.community.R;

public class PhotoFragment extends Fragment {

    PhotoList photolist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_photo,container,false);

        photolist = new PhotoList();
        getFragmentManager().beginTransaction().replace(R.id.photo_container, photolist).commit();

        return rootView;
    }

}