package kwaksuin.portfolio.community.board.market;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kwaksuin.portfolio.community.R;
import kwaksuin.portfolio.community.board.photo.OnPhotoClickListener;

class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> implements OnMarketClickListener {

    ArrayList<Market> items = new ArrayList<Market>();

    OnMarketClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.market_item, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    // viewHolder에 사진게시판 내용 넣기
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Market item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Market item) {
        items.add(item);
    }

    public void setItems(ArrayList<Market> items) {
        this.items = items;
    }

    public Market getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Market item) {
        items.set(position, item);
    }

    public void setOnItemClickListener(OnMarketClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView MarketTitle;       // 제목
        TextView MarketLocal;       // 위치
        TextView Content;           // 본문내용
        TextView Count;             // 댓글 수
        ImageView contentImage;

        public ViewHolder(View itemView, final OnMarketClickListener listener) {
            super(itemView);


            MarketTitle = itemView.findViewById(R.id.MarketTitle);
            MarketLocal = itemView.findViewById(R.id.MarketLocal);
            Content = itemView.findViewById(R.id.content);
            Count = itemView.findViewById(R.id.count);

            contentImage = itemView.findViewById(R.id.content_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(MarketAdapter.ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Market item) {
            Count.setText(String.valueOf(item.getCount()));             // 좋아요 수
            MarketTitle.setText(item.getTitle());                       // 게시글 제목
            MarketLocal.setText(String.valueOf(item.getLocal()));       // 위치
            contentImage.setImageResource(item.getImages());            // 이미지
            Content.setText(String.valueOf(item.getContents()));        // 본문 내용
        }
    }
}
