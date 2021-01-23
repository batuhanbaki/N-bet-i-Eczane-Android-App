# Nöbetçi Eczane Android App


### Ekran Görüntüleri

<img align="left" width="200px" height="400px" src="https://kuzeyapi.com/Ideav/download/ss%20%282%29.jpg"/>
<img align="left" width="200px" height="400px" src="https://kuzeyapi.com/Ideav/download/ss%20%281%29.jpg"/>
<img align="left" width="200px" height="400px" src="https://kuzeyapi.com/Ideav/download/ss%20%283%29.jpg"/>
<img width="200px" height="400px" src="https://kuzeyapi.com/Ideav/download/ss%20%284%29.jpg"/>



### API Kaynağı

```
Tüm eczane listesi için: http://api.kodlama.net/eczane/all/
İl bazlı arama için: http://api.kodlama.net/eczane/il/#ilkodu
```

### Tüm Eczane Get Request & Response
```
Request URL: http://api.kodlama.net/eczane/all/
{
"id": "4541",
"eczane_adi": "Aladağ Eczanesi",
"eczane_ilce": "Aladağ",
"eczane_adres": "SİNANPAŞA MAH.İNÖNÜ CAD.NO:104",
"eczane_telefon": "03225912641",
"eczane_il": "01"
}
```

### İl Bazlı Arama Get Request & Response
```
Request URL : http://api.kodlama.net/eczane/il/#ilkodu
{
"eczane_adi": "Burgazada Eczanesi",
"eczane_ilce": "Adalar",
"eczane_adres": "Burgazadası Mah.Çınarlık Sok.No.3 Burgazada Adalar/İstanbul",
"eczane_telefon": "02163812112",
"eczane_il": "34"
}
```


### Yapılabilecekler
```
API kaynağı değiştirilebilir (mevcut apide bazı response fieldlarda hata var, api response sabit değil)
Kullanıcı deneyimi çalışmaları yapılabilir (Maps api, konum bazlı arama, eczane kaydetme gibi kullanıcı deneyimi arttıran özellikler eklenebilir)
UI Çalışmaları yapılabilir (2 saatte kodlandığı için ui elementlere önem verilmedi)
```
