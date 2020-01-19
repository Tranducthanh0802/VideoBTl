package tranthanh.dmt.videovesion10.HotVideo;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

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


import tranthanh.dmt.videovesion10.HotVideo.model.video_HotVideo;

public class hotvideo_Pressent {
    public static ArrayList<video_HotVideo> addVideo(final Context context) {
        final String tenduoi = "Thanh luis";
        final ArrayList<video_HotVideo> lisVD = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
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
                                lisVD.add(new video_HotVideo(anh.trim(), mota.trim(), tenduoi.trim(), time.trim()));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "loi!", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);

        return lisVD;
    }


}
