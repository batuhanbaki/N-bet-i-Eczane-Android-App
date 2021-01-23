package com.prod.nobetcimnerede;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EczaneDetayActivity extends AppCompatActivity {

    Bundle data;
    TextView eczaneadi,adres,telefon,ililce;
    Button ara,map;
    ImageView backbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczanedetay);
        setDec();
        setData();
        setPhoneSet();
        setMapsSettings();
    }

    void setDec()
    {
        data = getIntent().getExtras();
        eczaneadi = findViewById(R.id.eczaneadi);
        ililce = findViewById(R.id.eczaneililce);
        telefon = findViewById(R.id.eczanenum);
        adres = findViewById(R.id.eczaneadresdty);
        ara = findViewById(R.id.ara);
        map = findViewById(R.id.mapde);
        backbtn = findViewById(R.id.backBtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    void setData()
    {
        eczaneadi.setText(data.getString("eczanead"));
        String il = data.getString("eczaneilce")+"/"+data.getString("eczaneil");
        ililce.setText(il);
        try {
            String telefonparse = data.getString("eczanetel").substring(0,4) +" "+ data.getString("eczanetel").substring(4,7)+" "+data.getString("eczanetel").substring(7,9)+" "+data.getString("eczanetel").substring(9,11);
            telefon.setText(telefonparse);
        }catch (IndexOutOfBoundsException e)
        {
            telefon.setText(data.getString("eczanetel"));
        }

        String adresparse = "Adres: "+data.getString("eczaneadres").toLowerCase();
        adres.setText(adresparse);
    }

    void setPhoneSet()
    {
        ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = data.getString("eczanetel");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });
    }

    void setMapsSettings()
    {
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] eczanedata = data.getString("eczanead").split(" ");
                String query = "http://maps.google.com/?q=";
                for(String name : eczanedata)
                   query = query.concat(name+"+");
                query= query.concat(data.getString("eczaneil"));
                Log.d("link", ""+query);
                Uri uri = Uri.parse(query); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
