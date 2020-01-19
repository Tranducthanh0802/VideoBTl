package tranthanh.dmt.videovesion10.HotVideo.model;

import android.graphics.Bitmap;

public class video_HotVideo {
    private String anh;
    private String mota_Video;
    private String tenduoi_Video;
    private String timeDang_video;

    public video_HotVideo() {
    }

    public video_HotVideo(String mota_Video, String tenduoi_Video, String timeDang_video) {
        this.mota_Video = mota_Video;
        this.tenduoi_Video = tenduoi_Video;
        this.timeDang_video = timeDang_video;
    }

    public video_HotVideo(String anh, String mota_Video, String tenduoi_Video, String timeDang_video) {
        this.anh = anh;
        this.mota_Video = mota_Video;
        this.tenduoi_Video = tenduoi_Video;
        this.timeDang_video = timeDang_video;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMota_Video() {
        return mota_Video;
    }

    public void setMota_Video(String mota_Video) {
        this.mota_Video = mota_Video;
    }

    public String getTenduoi_Video() {
        return tenduoi_Video;
    }

    public void setTenduoi_Video(String tenduoi_Video) {
        this.tenduoi_Video = tenduoi_Video;
    }

    public String getTimeDang_video() {
        return timeDang_video;
    }

    public void setTimeDang_video(String timeDang_video) {
        this.timeDang_video = timeDang_video;
    }
}