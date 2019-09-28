package creo.com.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionManager {


    private SharedPreferences sharedPreferences;


    public SessionManager(Context  context){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getSourcLat() {
        String lat = sharedPreferences.getString("lat","");

        return lat;
    }

    public void setSourceLat(String lat) {
    sharedPreferences.edit().putString("lat",lat).commit();
    }

    public void setSourceLong(String longt){
        sharedPreferences.edit().putString("longt",longt).commit();
    }

    public String getSourcLong(){
        return  sharedPreferences.getString("longt","");
    }
    public String getDestLat(){
        return  sharedPreferences.getString("latt","");
    }
    public void setDestLat(String latt){
        sharedPreferences.edit().putString("latt",latt).commit();
    }

    public void setDestLong(String longtt){
        sharedPreferences.edit().putString("longtt",longtt).commit();
    }
    public String getDestLong(){

            return  sharedPreferences.getString("longt","");
    }
    /*public void setModel(String model){
        sharedPreferences.edit().putString("model",model).commit();
    }
    public String getModel(){

        return  sharedPreferences.getString("model","");
    }
    public void setYear(String year){
        sharedPreferences.edit().putString("year",year).commit();
    }
    public String getYear(){

        return  sharedPreferences.getString("year","");
    }
    public void setPlate(String plate){
        sharedPreferences.edit().putString("plate",plate).commit();
    }
    public String getPlate(){

        return  sharedPreferences.getString("plate","");
    }
    public void setColor(String color){
        sharedPreferences.edit().putString("color",color).commit();
    }
    public String getColor(){

        return  sharedPreferences.getString("color","");
    }
    public void setRC(String rcbook){
        sharedPreferences.edit().putString("rcbook",rcbook).commit();
    }
    public String getRC(){

        return  sharedPreferences.getString("rcbook","");
    }
    public void setPermit(String taxi_permit){
        sharedPreferences.edit().putString("taxi_permit",taxi_permit).commit();
    }
    public String getPermit(){

        return  sharedPreferences.getString("taxi_permit","");
    }
    public void setInsurance(String vehicle_insurance){
        sharedPreferences.edit().putString("vehicle_insurance",vehicle_insurance).commit();
    }
    public String getInsurance(){

        return  sharedPreferences.getString("vehicle_insurance","");
    }
    public void setTourist(String tourist_permit){
        sharedPreferences.edit().putString("tourist_permit",tourist_permit).commit();
    }
    public String getTourist(){

        return  sharedPreferences.getString("tourist_permit","");
    }
    public void setFitness(String vehicle_fitness){
        sharedPreferences.edit().putString("vehicle_fitness",vehicle_fitness).commit();
    }
    public String getFitness(){

        return  sharedPreferences.getString("vehicle_fitness","");
    }
    public void setNOC(String noc){
        sharedPreferences.edit().putString("noc",noc).commit();
    }
    public String getNOC(){

        return  sharedPreferences.getString("noc","");
    }
    public void setPho(String img){
        sharedPreferences.edit().putString("img",img).commit();
    }
    public String getPho(){

        return  sharedPreferences.getString("img","");
    }


*/

}
