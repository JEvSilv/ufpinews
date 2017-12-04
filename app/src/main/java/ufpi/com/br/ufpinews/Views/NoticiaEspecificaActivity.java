package ufpi.com.br.ufpinews.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;

import ufpi.com.br.ufpinews.R;

/**
 * Created by jonin on 04/12/2017.
 */

public class NoticiaEspecificaActivity extends AppCompatActivity {
//    public RequestQueue queue;
//    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticia_especifica_content);
    }
}
