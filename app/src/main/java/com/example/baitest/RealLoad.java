package com.example.baitest;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

public class RealLoad implements Display{

    Context context;

    public RealLoad(Context context){
        this.context = context;
    }

    @Override
    public String load() {
        String jsonText = null;
        StringBuffer buffer = new StringBuffer();
        try {
            jsonText = readText(context, R.raw.mock);
            JSONObject jsonRoot = new JSONObject(jsonText);
            JSONArray array = jsonRoot.getJSONArray("danhba");
            Number numbers[] = new Number[array.length()];
            for (int i = 0 ; i < array.length() ; i++){
                JSONObject objectDB = array.getJSONObject(i);
                int number = objectDB.getInt("number");
                numbers[i] = new Number();
                numbers[i].setNumber(number);
                buffer.append(numbers[i].getNumber() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

}
