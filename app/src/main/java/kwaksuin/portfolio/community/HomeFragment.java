package kwaksuin.portfolio.community;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kwaksuin.portfolio.community.board.free.FreeFragment;
import kwaksuin.portfolio.community.board.free.FreeList;
import kwaksuin.portfolio.community.board.market.MarketFragment;
import kwaksuin.portfolio.community.board.photo.PhotoFragment;
import kwaksuin.portfolio.community.board.photo.PhotoList;
import kwaksuin.portfolio.community.board.quest.QuestFragment;
import kwaksuin.portfolio.community.board.quest.QuestList;

public class HomeFragment extends Fragment {
    FreeFragment freePage;
    PhotoFragment photoPage;
    QuestFragment questPage;
    MarketFragment marketPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home,container,false);

        freePage = new FreeFragment();
        TextView free = rootView.findViewById(R.id.freeButton);
        free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container,freePage).commit();
            }
        });

        photoPage = new PhotoFragment();
        TextView photo = rootView.findViewById(R.id.photoButton);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container,photoPage).commit();
            }
        });

        questPage = new QuestFragment();
        TextView quest = rootView.findViewById(R.id.questButton);
        quest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container,questPage).commit();

            }
        });

        marketPage = new MarketFragment();
        TextView market = rootView.findViewById(R.id.marketButton);
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container,marketPage).commit();
            }
        });

        GridView photoList = rootView.findViewById(R.id.gridView);
        photoList.setAdapter(new ImageAdapter(getContext()));


        return rootView;

    }

    public class ImageAdapter extends BaseAdapter{
        public Context context;

        public Integer[] images = {R.drawable.dog, R.drawable.dog, R.drawable.dog, R.drawable.dog};

        public ImageAdapter(Context con){
            this.context = con;
        }

        public int getCount(){
            return images.length;
        }

        @Override
        public Object getItem(int pos){
            return null;
        }

        @Override
        public long getItemId(int position){
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imageView;

            if(convertView == null){
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //imageView.setPadding(10,10,10,10);
            }else{
                imageView = (ImageView)convertView;
            }
            imageView.setImageResource(images[position]);

            return imageView;
        }
    }

}