package kwaksuin.portfolio.community.board.quest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kwaksuin.portfolio.community.R;

// Adapter는 데이터들을 리스트에 넣어주는 역할
// 데이터와 리스트뷰를 연결해주는 역할
public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.ViewHolder>{

    private List<Quest_board> boardList;

    public QuestAdapter(List<Quest_board> boardList){
        this.boardList = boardList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.quest_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuestAdapter.ViewHolder holder, int position) {
        Quest_board data = boardList.get(position);
        holder.title.setText(data.getTitle());          // 제목
        holder.name.setText(data.getName());            // 닉네임
        holder.contents.setText(data.getContents());    // 내용
        holder.review.setText(data.getReview());        // 댓글 수
    }

    @Override
    public int getItemCount() {
        return boardList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView name;
        private TextView contents;
        private TextView review;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.quest_title);
            name = itemView.findViewById(R.id.quest_name);
            contents = itemView.findViewById(R.id.quest_contents);
            review = itemView.findViewById(R.id.quest_review);

        }

    }
}
