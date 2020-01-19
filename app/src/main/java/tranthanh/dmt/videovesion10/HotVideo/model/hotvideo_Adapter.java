package tranthanh.dmt.videovesion10.HotVideo.model;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import tranthanh.dmt.videovesion10.R;

public class hotvideo_Adapter extends RecyclerView.Adapter<hotvideo_Adapter.ViewHolder> {
    List<video_HotVideo> listvideo;
    Context context;





    private LayoutInflater layoutInflater;


    public hotvideo_Adapter(List<video_HotVideo> listvideo, Context context) {
        this.listvideo = listvideo;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.hotvideo_adapter,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        video_HotVideo vd=listvideo.get(position);
        String s=vd.getAnh();

        Picasso.with(context).load(s.toString()).fit().centerInside().into(holder.img);
        Picasso.with(context).load(vd.getAnh()).into(holder.img);
        holder.txtTen.setText(vd.getMota_Video().toString());
        holder.txttenDuoi.setText(vd.getTenduoi_Video().toString());
        holder.txttimeDang.setText(vd.getTimeDang_video().toString());
    }

    @Override
    public int getItemCount() {
        return listvideo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTen,txttenDuoi,txttimeDang;
        public ViewHolder( View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            txtTen=itemView.findViewById(R.id.txtTen);
            txttenDuoi=itemView.findViewById(R.id.txtMota);
            txttimeDang=itemView.findViewById(R.id.txtTime);
        }
    }
}
