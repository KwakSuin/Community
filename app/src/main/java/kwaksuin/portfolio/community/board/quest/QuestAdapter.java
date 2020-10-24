package kwaksuin.portfolio.community.board.quest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kwaksuin.portfolio.community.R;

public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.ViewHolder>
        implements OnQuestClickListener {

    ArrayList<QuestInfo> items = new ArrayList<QuestInfo>();

    OnQuestClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.quest_item, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        QuestInfo item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(QuestInfo item) {
        items.add(item);
    }

    public void setItems(ArrayList<QuestInfo> items) {
        this.items = items;
    }

    public QuestInfo getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, QuestInfo item) {
        items.set(position, item);
    }

    public void setOnItemClickListener(OnQuestClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onQuestClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onQuestClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView quest_title;
        TextView quest_name;
        TextView quest_content;
        ImageView imageView;

        public ViewHolder(View itemView, final OnQuestClickListener listener) {
            super(itemView);

            quest_title = itemView.findViewById(R.id.quest_title);
            quest_name = itemView.findViewById(R.id.quest_name);
            quest_content = itemView.findViewById(R.id.quest_contents);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onQuestClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(QuestInfo item) {
            quest_title.setText(item.getTitle());
            quest_name.setText(item.getName());
            quest_content.setText(item.getContents());
        }

    }
}
