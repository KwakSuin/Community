package kwaksuin.portfolio.community.board.photo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kwaksuin.portfolio.community.R;

public class Photo{

        String Phototitle;
        String PhotoDate;
        int count;
        int imageRes;

    public Photo() {

    }

    public Photo(String phototitle, String photodate, int count, int imageRes) {
        this.Phototitle = phototitle;
        this.PhotoDate = photodate;
        this.count = count;
        this.imageRes = imageRes;
    }

    public String getPhototitle() {
        return Phototitle;
    }

    public void setPhototitle(String Phototitle) {
        this.Phototitle = Phototitle;
    }

    public String getPhotoDate() {
        return PhotoDate;
    }

    public void setPhotoDate(String PhotoDate) {
        this.PhotoDate = PhotoDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count= count;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

}