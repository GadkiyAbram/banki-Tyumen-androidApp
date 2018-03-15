package com.example.aleksandrabramovski.webparsingjson;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String LOG_TAG = "rate";

    public ArrayAdapter<BankRates> adapter;
    public ListView lv;
    public ArrayList<BankRates> bankRates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listView1);

        bankRates = new ArrayList<BankRates>();

        adapter = new BankRatesAdapter(this, bankRates);
        lv.setAdapter(adapter);

        new BankRatesThread().execute();

    }

    public class BankRatesThread extends AsyncTask<Void, Void, List<BankRates>>{
        @Override
        protected List<BankRates> doInBackground(Void... voids){
            try{
                Document doc = Jsoup.connect("http://www.banki.ru/products/currency/cash/tyumen~/").get();

                Elements bNames = doc.select("tr[data-currencies-row]");

                for (Element elem : bNames){
                    String bankName = elem.child(0).getElementsByAttributeValue("class", "font-bold").text();
                    String rateBuyUSD = elem.child(1).select("td[class^=font-size-large]").text();
                    String rateSellUSD = elem.child(2).select("td[class^=font-size-large]").text();
                    String rateBuyEURO = elem.child(4).select("td[class^=font-size-large]").text();
                    String rateSellEURO = elem.child(5).select("td[class^=font-size-large]").text();
                    String rateUpdated = elem.child(6).select("td[class^=color-border-dark]").text();
                    bankRates.add(new BankRates(bankName, rateBuyUSD, rateSellUSD, rateBuyEURO, rateSellEURO, rateUpdated));
                    Log.d(LOG_TAG, "Inserted: " + bankName + ", " + rateBuyUSD);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return bankRates;
        }

        @Override
        protected void onPostExecute(List<BankRates> data){
            if (adapter != null && !adapter.isEmpty()){
                adapter.addAll(data);
                Log.d(LOG_TAG, "Data uploaded");
            }else{
                Log.d(LOG_TAG, "Adapter is Empty");
            }
        }
    }
}
