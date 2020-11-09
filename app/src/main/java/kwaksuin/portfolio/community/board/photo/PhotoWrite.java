package kwaksuin.portfolio.community.board.photo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import kwaksuin.portfolio.community.R;

public class PhotoWrite extends Fragment {
    Photolist photolist;

    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_iMAGE = 2;

    private Uri mImageCaptureUri;
    private ImageView photoWriteImage;
    private int id_view;
    private String path;

    public class FragmentTag{
        public static final String FRAMGET_TAG = "photo";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.photo_write,container,false);

        photolist = new Photolist();
        
        // 올리기 버튼 누르면 게시글 목록으로 이동
        Button writeButton = rootView.findViewById(R.id.photoWriteButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"게시글을 등록하였습니다.",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.photo_container, photolist).commit();

            }
        });

        // 사진첨부 버튼
        Button photoAddButton = rootView.findViewById(R.id.photoAddButon);
        photoAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rootView;
    }
}