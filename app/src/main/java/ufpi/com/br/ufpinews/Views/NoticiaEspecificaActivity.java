package ufpi.com.br.ufpinews.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import ufpi.com.br.ufpinews.Adapter.ClickListener;
import ufpi.com.br.ufpinews.Adapter.NoticiaAdapter;
import ufpi.com.br.ufpinews.Adapter.RecyclerTouchListener;
import ufpi.com.br.ufpinews.Models.Noticia;
import ufpi.com.br.ufpinews.R;

/**
 * Created by jonin on 04/12/2017.
 */

public class NoticiaEspecificaActivity extends AppCompatActivity {
    public RequestQueue queue;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticiaespecifica);
    }
}
