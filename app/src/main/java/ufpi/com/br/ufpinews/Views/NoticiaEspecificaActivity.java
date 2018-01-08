package ufpi.com.br.ufpinews.Views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ufpi.com.br.ufpinews.Adapter.LinkAdapter;
import ufpi.com.br.ufpinews.Adapter.NoticiaAdapter;
import ufpi.com.br.ufpinews.Models.Noticia;
import ufpi.com.br.ufpinews.Models.NoticiaEspecifica;
import ufpi.com.br.ufpinews.R;

/**
 * Created by jonin on 04/12/2017.
 */

public class NoticiaEspecificaActivity extends AppCompatActivity {
    public RequestQueue queue;
    private String href;
    private List<NoticiaEspecifica> noticiaEspecificaList;
    private ArrayList<String> urls_img;
    private TextView body;
    private TextView title;
    private ImageView img_id;
    private Button prox;
    private LinearLayout layout;
    private Integer it_img;
    private View prox_view;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticia_especifica_content);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        urls_img = new ArrayList<String>();
        href = (String) bd.get ("href");
        it_img = 0;
        body = (TextView) findViewById(R.id.body);
        title = (TextView) findViewById(R.id.titlene);
        img_id = (ImageView) findViewById(R.id.img_id);
        prox = (Button) findViewById(R.id.Prox);
        prox_view = findViewById(R.id.Prox);
        layout = (LinearLayout) findViewById(R.id.layout);
        //linkAdapter

        mRecyclerView = (RecyclerView) findViewById(R.id.show_links);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //img_id.setImageBitmap(bmp);
        prox_view.setVisibility(View.GONE);
        title.setText((String) bd.get ("title"));
        queue = Volley.newRequestQueue(this);



        String url ="http://10.94.15.102:8000/noticiaespecifica";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                          Type listType = new TypeToken<ArrayList<NoticiaEspecifica>>(){}.getType();
                          noticiaEspecificaList = new Gson().fromJson(response.toString(), listType);
                          noticiaProcess();
                          getImages();


                        //if(urls_img.size() == 0){
                        //}else{
                           //   Picasso.with(NoticiaEspecificaActivity.this).load("http://ufpi.br"+urls_img.get(0)).into(img_id);
                         // }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //body.setText("That didn't work!");
            }
        }){

            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("data", href);
                return params;
            }

        };
        queue.add(stringRequest);

        prox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it_img++;
                Integer pos = it_img%urls_img.size();
                Picasso.with(NoticiaEspecificaActivity.this).load("http://ufpi.br"+urls_img.get(pos)).into(img_id);
            }
        });
    }

    void noticiaProcess(){
        System.out.println(noticiaEspecificaList.toString());
        List<String> links_list = new ArrayList<String>();
        String text = "";
        for(NoticiaEspecifica ne: noticiaEspecificaList){
            if(ne.etext){
                text = text + ne.text +'\n'+'\n';
            }

            if(ne.link){
                links_list.add(ne.href);
            }
        }
        mAdapter = new LinkAdapter(links_list);
        mRecyclerView.setAdapter(mAdapter);
        body.setText(Html.fromHtml(text));
    }

    void getImages(){
        for(NoticiaEspecifica ne: noticiaEspecificaList){
            if(ne.eimg){
                urls_img.add(ne.getImg());
            }
        }
        if(!urls_img.isEmpty()){
            if(urls_img.size() > 1){
                prox_view.setVisibility(View.VISIBLE);
            }
            Picasso.with(NoticiaEspecificaActivity.this).load("http://ufpi.br"+urls_img.get(0)).into(img_id);
        }

    }


}
