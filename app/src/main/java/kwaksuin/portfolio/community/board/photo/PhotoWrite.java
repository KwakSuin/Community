package kwaksuin.portfolio.community.board.photo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import kwaksuin.portfolio.community.ProfileFragment;
import kwaksuin.portfolio.community.R;

import static android.app.Activity.RESULT_OK;

public class PhotoWrite extends Fragment {
    PhotoList photolist;

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

        photolist = new PhotoList();
        photoWriteImage = rootView.findViewById(R.id.photoWriteImage);
        
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
        photoWriteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.photoWriteImage){
                    DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 사진첨부 함수
                            doTakePhotoAction();
                        }
                    };

                    // dialog 선택하면 dialog 사라지게 하는 것
                    DialogInterface.OnClickListener cacnleListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    };

                    // dialog 박스
                    new AlertDialog.Builder(getContext())
                            .setTitle("사진첨부")
                            .setPositiveButton("앨범선택",cameraListener)
                            .setNegativeButton("취소",cacnleListener)
                            .show();
                }
            }
        });
        return rootView;
    }

    // 앨범에서 이미지 가져오기
    public void doTakePhotoAction(){
        // 앨범 호출
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent,PICK_FROM_ALBUM);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        Fragment fragment = getFragmentManager().findFragmentByTag(ProfileFragment.FragmentTag.FRAMGET_TAG);
        if(fragment != null){
            ((ProfileFragment) fragment).onActivityResult(requestCode,resultCode,data);
        }

        if(resultCode != RESULT_OK)
            return;

        switch (requestCode){
            case PICK_FROM_ALBUM : {
                mImageCaptureUri = data.getData();
            }
            case PICK_FROM_CAMERA : {
                // 이미지를 가져온 후, 이미지 크기 조절
                Intent intent = new Intent("com.android.camera.action.CROP");

                // 갤러리 불러오기
                intent.setDataAndType(mImageCaptureUri,"image/*");

                // 사진크기조절
                intent.putExtra("scale",true);
                intent.putExtra("return-data",true);
                startActivityForResult(intent,CROP_FROM_iMAGE);
                break;
            }
            case CROP_FROM_iMAGE : {
                if(resultCode != RESULT_OK){
                    return;
                }

                final Bundle extras = data.getExtras();

                // 조절한 사진 저장
                // 폴더명 : Community
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()
                        +"/Community"+System.currentTimeMillis()+".jpg";

                if(extras != null){
                    // 조절한 사진받아오기
                    Bitmap photo = extras.getParcelable("data");

                    // 조절된 사진을 보여줌
                    photoWriteImage.setImageBitmap(photo);
                    storeCropImage(photo,filePath);
                    path = filePath;
                    break;
                }

                File file = new File(mImageCaptureUri.getPath());
                if(file.exists()){
                    file.delete();
                }
            }
        }
    }

    private void storeCropImage(Bitmap bitmap, String filePath){
        String directoryPath = Environment.getDataDirectory().getAbsolutePath()+"/Community";
        File directory_Community = new File(directoryPath);

        // Community 디렉터리에 폴더가 없으면 폴더 생성
        if(!directory_Community.exists()){
            directory_Community.mkdir();
        }

        File copyFile = new File(filePath);
        BufferedOutputStream outputStream = null;

        try{
            copyFile.createNewFile();
            outputStream = new BufferedOutputStream(new FileOutputStream(copyFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);

            outputStream.flush();
            outputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}