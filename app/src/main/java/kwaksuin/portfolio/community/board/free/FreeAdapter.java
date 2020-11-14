package kwaksuin.portfolio.community.board.free;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kwaksuin.portfolio.community.R;
import kwaksuin.portfolio.community.board.free.Free_board;

public class FreeAdapter extends RecyclerView.Adapter<FreeAdapter.ViewHolder>{

    private List<Free_board> boardList;

    public FreeAdapter(List<Free_board> boardList){
        this.boardList = boardList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.free_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FreeAdapter.ViewHolder holder, int position) {
        Free_board data = boardList.get(position);
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

            title = itemView.findViewById(R.id.free_title);
            name = itemView.findViewById(R.id.free_name);
            contents = itemView.findViewById(R.id.free_contents);
            review = itemView.findViewById(R.id.free_review);

        }
    }
}
