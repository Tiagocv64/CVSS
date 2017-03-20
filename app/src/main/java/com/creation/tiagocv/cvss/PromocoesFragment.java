package com.creation.tiagocv.cvss;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PromocoesFragment extends Fragment {

    public PromocoesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_promocoes, container, false);

        ArrayList<String[]> arrayList = new ArrayList<>();
        String[] informaçao = {"Vacinas" , "Todas as vacinas estaram em promoção até dia 23 de Março"} ;
        String[] informaçao2 = {"Vacinas" , "Todas as vacinas estaram em promoção até dia 24 de Março"} ;
        String[] informaçao3 = {"Vacinas" , "Todas as vacinas estaram em promoção até dia 25 de Março"} ;
        String[] informaçao4 = {"Vacinas" , "Todas as vacinas estaram em promoção até dia 26 de Março"} ;
        arrayList.add(informaçao);
        arrayList.add(informaçao2);
        arrayList.add(informaçao3);
        arrayList.add(informaçao4);


        ListView listView = (ListView) view.findViewById(R.id.list_view_promocoes);
        PromocoesAdapter adapter = new PromocoesAdapter(getActivity(), arrayList);
        listView.setAdapter(adapter);

        return view ;
    }


}
