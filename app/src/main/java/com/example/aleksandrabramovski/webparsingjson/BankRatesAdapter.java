package com.example.aleksandrabramovski.webparsingjson;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BankRatesAdapter extends ArrayAdapter<BankRates>{

    public BankRatesAdapter(Activity context, ArrayList<BankRates> arrayList){
        super(context, 0, arrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View itemView = convertView;

        if (itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        BankRates bankrates = getItem(position);

        TextView bankName = (TextView) itemView.findViewById(R.id.bankName);
        bankName.setText(bankrates.getBankName());

        TextView rateBuyUSD = (TextView) itemView.findViewById(R.id.usdBuy);
        rateBuyUSD.setText(bankrates.getRateBuyUSD());

        TextView rateSellUSD = (TextView) itemView.findViewById(R.id.usdSell);
        rateSellUSD.setText(bankrates.getRateSellUSD());

        TextView rateBuyEURO = (TextView) itemView.findViewById(R.id.eurBuy);
        rateBuyEURO.setText(bankrates.getRateBuyEURO());

        TextView rateSellEURO = (TextView) itemView.findViewById(R.id.eurSell);
        rateSellEURO.setText(bankrates.getRateSellEURO());

        TextView ratesUpdt = (TextView) itemView.findViewById(R.id.rateUpdated);
        ratesUpdt.setText(bankrates.getRateUpdt());

        return itemView;
    }
}