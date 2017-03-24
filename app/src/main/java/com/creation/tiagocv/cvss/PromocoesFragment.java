package com.creation.tiagocv.cvss;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Map;

public class PromocoesFragment extends Fragment {

    public DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Promoçoes");
    FirebaseStorage storage = FirebaseStorage.getInstance();
    // Create a storage reference from our app
    StorageReference storageRef = storage.getReference();
    ArrayList<String[]> listPromoçoes = new ArrayList<String[]>();

    public PromocoesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        databaseReference.keepSynced(true);

        final View view = inflater.inflate(R.layout.fragment_promocoes, container, false);

        databaseReference.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        getPromoçoesInformation((Map<String,Object>) dataSnapshot.getValue());

                        ListView listView = (ListView) view.findViewById(R.id.list_view_promocoes);
                        PromocoesAdapter adapter = new PromocoesAdapter(getActivity(), listPromoçoes);
                        listView.setAdapter(adapter);
                        view.findViewById(R.id.loading_promoçoes).setVisibility(View.GONE);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
        return view ;
    }


    private void getPromoçoesInformation(Map<String,Object> users) {



        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()){

            String[] informaçao = new String[3];

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            informaçao[0] = singleUser.get("Titulo").toString();
            informaçao[1] = singleUser.get("Descriçao").toString();
            informaçao[2] = singleUser.get("Imagem").toString();

            listPromoçoes.add(informaçao);
        }
    }


}
