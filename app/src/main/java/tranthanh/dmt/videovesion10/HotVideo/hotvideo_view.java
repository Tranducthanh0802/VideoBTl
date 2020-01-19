package tranthanh.dmt.videovesion10.HotVideo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import tranthanh.dmt.videovesion10.HotVideo.model.hotvideo_Adapter;
import tranthanh.dmt.videovesion10.HotVideo.model.video_HotVideo;
import tranthanh.dmt.videovesion10.R;

public class hotvideo_view extends Fragment {
    ArrayList<video_HotVideo> listVd;
    hotvideo_Adapter Adap;
    RecyclerView listview ;

    public static hotvideo_view newInstance() {

        Bundle args = new Bundle();

        hotvideo_view fragment = new hotvideo_view();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.layout_hotvideo1,container,false);
        listview=(RecyclerView) view.findViewById(R.id.recyview);
        //listVd=hotvideo_Pressent.addVideo(view.getContext());
        final String tenduoi = "Thanh luis";
        listVd = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, openFile.url.trim(), null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                String anh = object.getString("avatar");
                                String mota = object.getString("title");
                                String time = object.getString("date_published");
                                listVd.add(new video_HotVideo(anh.trim(), mota.trim(), tenduoi.trim(), time.trim()));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(view.getContext(), "loi!", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(request);
        Adap=new hotvideo_Adapter(listVd,view.getContext());
        StaggeredGridLayoutManager gridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        listview.setLayoutManager(gridLayoutManager);
        listview.setAdapter(Adap);
        Adap.notifyDataSetChanged();
        return view;
    }
    class doGetData extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {

            return null;
        }
    }
}
