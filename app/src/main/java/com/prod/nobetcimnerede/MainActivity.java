package com.prod.nobetcimnerede;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.prod.nobetcimnerede.API.GetEczaneDatas;
import com.prod.nobetcimnerede.Adapter.EczaneAdapter;
import com.prod.nobetcimnerede.Models.EczaneDataModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  SwipeRefreshLayout.OnRefreshListener
{
    TextView nodata;
    GetEczaneDatas getData;
    RecyclerView recyclerView;
    EczaneAdapter eczane_adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    Spinner illerspinner;
    public String[] sehirler = {"", "Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
            "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
            "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum ", "Eskişehir",
            "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
            "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya ", "Malatya",
            "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya",
            "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon  ", "Tunceli", "Şanlıurfa", "Uşak",
            "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt ", "Karaman", "Kırıkkale", "Batman", "Şırnak",
            "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük ", "Kilis", "Osmaniye ", "Düzce"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDeclaration();
        setIlSelectedSearch();
    }

    void setDeclaration()
    {
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        nodata = findViewById(R.id.nodatatw);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        illerspinner = findViewById(R.id.illerspinner);
        illerspinner.setDropDownVerticalOffset(150);
        getData = new GetEczaneDatas();
        getData.getAllEczane();
        final ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "",
                "Eczaneler yükleniyor, bekleyiniz...", true);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setEczaneDatas(getData.getEczaneList());
                dialog.cancel();
            }
        }, 2000);
    }

    void setIlSelectedSearch()
    {
        illerspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!illerspinner.getSelectedItem().toString().equals("İl Bazlı Arama Yapın")) {
                    getData = new GetEczaneDatas();
                    getData.getbyIlEczane(getIlNumber(illerspinner.getSelectedItem().toString()));
                    final ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "",
                            "Eczaneler yükleniyor, bekleyiniz...", true);
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            setEczaneDatas(getData.getEczaneList());
                            dialog.cancel();
                        }
                    }, 1000);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    String getIlNumber(String ilAd) {
        int donecekid =0;
        for (int i = 1; i <= 81; i++) {
            if (sehirler[i].toLowerCase().equals(ilAd.toLowerCase())) {
                donecekid = i;
                break;
            }
        }
        if(donecekid>0 && donecekid<10)
            return "0"+donecekid;
        else if(donecekid>=10)
            return ""+donecekid;
        else
            return "34";
    }

    public void setEczaneDatas(List<EczaneDataModel> eczaneDatas) {
        if(eczaneDatas.size()>0) {
            nodata.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            layoutManager.scrollToPosition(0);
            recyclerView.setLayoutManager(layoutManager);
            eczane_adapter = new EczaneAdapter(eczaneDatas);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(eczane_adapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
        else
        {
            nodata.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onRefresh() {
        getData.getAllEczane();
        final ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "",
                "Eczaneler yükleniyor, bekleyiniz...", true);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setEczaneDatas(getData.getEczaneList());
                dialog.cancel();
            }
        }, 2000);
        swipeRefreshLayout.setRefreshing(false);
    }

    Boolean cikis = false;
    @Override
    public void onBackPressed() {

            if (cikis) {
                super.onBackPressed();
            } else {
                cikis = true;
                Toast.makeText(this, "Çıkmak için tekrar basın", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cikis = false;
                    }
                }, 2000);
            }
    }
}
