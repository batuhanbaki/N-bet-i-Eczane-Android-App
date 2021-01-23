package com.prod.nobetcimnerede.API;

import android.util.Log;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.prod.nobetcimnerede.Models.EczaneDataModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetEczaneDatas {

    private static String urlAll = "https://api.kodlama.net/eczane/all/";
    private static String urlIl = "https://api.kodlama.net/eczane/il/";
    private List<EczaneDataModel> eczane_list;
    public String[] sehirler = {"", "Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
            "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
            "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum ", "Eskişehir",
            "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
            "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya ", "Malatya",
            "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya",
            "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon  ", "Tunceli", "Şanlıurfa", "Uşak",
            "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt ", "Karaman", "Kırıkkale", "Batman", "Şırnak",
            "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük ", "Kilis", "Osmaniye ", "Düzce"};


    public void getAllEczane()
    {
        eczane_list = new ArrayList<EczaneDataModel>();
        AndroidNetworking.get(urlAll)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            JSONArray datas = response.getJSONArray("data");
                            for(int i=0;i<datas.length();i++)
                            {
                                JSONObject objects = datas.getJSONObject(i);
                                eczane_list.add(
                                        new EczaneDataModel(
                                                objects.getString("eczane_adi"),
                                                objects.getString("eczane_ilce"),
                                                objects.getString("eczane_adres"),
                                                objects.getString("eczane_telefon"),
                                                getStringIl(objects.getString("eczane_il"))
                                        ));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONException",e.getMessage());
                        }
                    }
                    @Override
                    public void onError(ANError anError)
                    {
                        Log.e("JSONException","hata 2. kısım: "+anError.getMessage());
                    }
                });
    }


    public void getbyIlEczane(String ilId)
    {
        eczane_list = new ArrayList<EczaneDataModel>();
        String createdurl = urlIl.concat(ilId);
        AndroidNetworking.get(createdurl)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            JSONArray datas = response.getJSONArray("data");
                            for(int i=0;i<datas.length();i++)
                            {
                                JSONObject objects = datas.getJSONObject(i);
                                eczane_list.add(
                                        new EczaneDataModel(
                                                objects.getString("eczane_adi"),
                                                objects.getString("eczane_ilce"),
                                                objects.getString("eczane_adres"),
                                                objects.getString("eczane_telefon"),
                                                getStringIl(objects.getString("eczane_il"))
                                        ));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONException",e.getMessage());
                        }
                    }
                    @Override
                    public void onError(ANError anError)
                    {

                    }
                });
    }



    public String getStringIl(String ilInt)
    {
        return sehirler[Integer.parseInt(ilInt)];
    }

    public List<EczaneDataModel> getEczaneList()
    {
        return eczane_list;
    }

}
