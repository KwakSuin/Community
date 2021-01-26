package kwaksuin.portfolio.community.board.photo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kwaksuin.portfolio.community.R;

class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder>
        implements OnPhotoClickListener {
    ArrayList<Photo> items = new ArrayList<Photo>();

    OnPhotoClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.photo_item, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    // viewHolder에 사진게시판 내용 넣기
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Photo item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Photo item) {
        items.add(item);
    }

    public void setItems(ArrayList<Photo> items) {
        this.items = items;
    }

    public Photo getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Photo item) {
        items.set(position, item);
    }

    public void setOnItemClickListener(OnPhotoClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView PhotoTitle;    // 제목
        TextView PhotoDate;     // 작성날짜
        TextView Content;       // 본문
        TextView Count;         // 댓글 수

        ImageView contentImage;

        public ViewHolder(View itemView, final OnPhotoClickListener listener) {
            super(itemView);

            PhotoTitle = itemView.findViewById(R.id.Phototitle);
            PhotoDate = itemView.findViewById(R.id.Photodate);
            Content = itemView.findViewById(R.id.content);
            Count = itemView.findViewById(R.id.count);

            contentImage = itemView.findViewById(R.id.content_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Photo item) {
            Count.setText(String.valueOf(item.getCount()));          // 좋아요 수
            PhotoTitle.setText(item.getPhototitle());                // 게시글 제목
            PhotoDate.setText(String.valueOf(item.getPhotoDate()));  // 게시글 날짜
            contentImage.setImageResource(item.getImageRes());       // 사진
        }



    }
}
