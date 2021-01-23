package com.prod.nobetcimnerede.Models;

public class EczaneDataModel {

    private String eczane_adi;
    private String eczane_ilce;
    private String eczane_adres;
    private String eczane_telefon;
    private String eczane_il;

    public EczaneDataModel(String eczane_adi, String eczane_ilce, String eczane_adres, String eczane_telefon, String eczane_il) {
        this.eczane_adi = eczane_adi;
        this.eczane_ilce = eczane_ilce;
        this.eczane_adres = eczane_adres;
        this.eczane_telefon = eczane_telefon;
        this.eczane_il = eczane_il;
    }

    public String getEczane_adi() {
        return eczane_adi;
    }

    public void setEczane_adi(String eczane_adi) {
        this.eczane_adi = eczane_adi;
    }

    public String getEczane_ilce() {
        return eczane_ilce;
    }

    public void setEczane_ilce(String eczane_ilce) {
        this.eczane_ilce = eczane_ilce;
    }

    public String getEczane_adres() {
        return eczane_adres;
    }

    public void setEczane_adres(String eczane_adres) {
        this.eczane_adres = eczane_adres;
    }

    public String getEczane_telefon() {
        return eczane_telefon;
    }

    public void setEczane_telefon(String eczane_telefon) {
        this.eczane_telefon = eczane_telefon;
    }

    public String getEczane_il() {
        return eczane_il;
    }

    public void setEczane_il(String eczane_il) {
        this.eczane_il = eczane_il;
    }
}
