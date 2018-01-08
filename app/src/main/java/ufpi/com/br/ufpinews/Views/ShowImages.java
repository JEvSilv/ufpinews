package ufpi.com.br.ufpinews.Views;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//import ufpi.com.br.ufpinews.Adapter.ImagesAdapter;
import ufpi.com.br.ufpinews.R;

/**
 * Created by jonin on 13/12/2017.
 */

public class ShowImages extends AppCompatActivity {
    private ImageView sw_img;
    private Bitmap bitmap;
    private Button ant, prox;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_images);
        sw_img = (ImageView) findViewById(R.id.imgsw);
        ant = (Button) findViewById(R.id.Anterior);
        prox = (Button) findViewById(R.id.Proximo);
        Picasso.with(this).load("http://ufpi.br/images/arquivos_download/Noticias/profa_carminha.jpg").into(sw_img);


        prox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(ShowImages.this).load("http://ufpi.br/images/arquivos_download/Noticias/profa_adriana.jpg").into(sw_img);

                //sw_img.setImageURI();
            }
        });

        ant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sw_img.setImageURI();
            }
        });
    }
}
