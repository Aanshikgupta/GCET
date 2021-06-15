package com.example.gcet.UI.Gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gcet.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private RecyclerView freshersRecyclerView,convocationRecyclerView,unifestRecyclerView;
    private View view;
    private List<Gallery> freshersList,convocationList, unifestList;
    private DatabaseReference databaseReference,ref;
    private GalleryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_gallery, container, false);
        setFirebase();
        setRecyclerView();
        getFreshersDayData();
        getConvocation();
        getUnifest();
        return view;
    }

    private void getUnifest() {

        DatabaseReference temp=ref.child("Unifest");
        temp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                unifestList=new ArrayList<>();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    unifestList.add(0,dataSnapshot.getValue(Gallery.class));
                }
                adapter=new GalleryAdapter(view.getContext(),unifestList);
                adapter.notifyDataSetChanged();
                unifestRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(),"Something went wrong,please try again!",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getConvocation() {
        DatabaseReference temp=ref.child("Convocation");
        temp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                convocationList=new ArrayList<>();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    convocationList.add(0,dataSnapshot.getValue(Gallery.class));
                }
                adapter=new GalleryAdapter(view.getContext(),convocationList);
                adapter.notifyDataSetChanged();
                convocationRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(),"Something went wrong,please try again!",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getFreshersDayData() {
        DatabaseReference temp=ref.child("Fresher's day");
        Log.i("TAG","here");
        temp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                freshersList=new ArrayList<>();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    freshersList.add(0,dataSnapshot.getValue(Gallery.class));
                    Log.i("TAG",dataSnapshot.getValue(Gallery.class).getImageUrl());
                }
                adapter=new GalleryAdapter(view.getContext(),freshersList);
//                adapter.notifyDataSetChanged();
                freshersRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(),"Something went wrong,please try again!",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setFirebase() {
        databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference=databaseReference.child("Gallery");
        ref=databaseReference;

    }

    private void setRecyclerView() {
        freshersRecyclerView=view.findViewById(R.id.fresherDayRecyclerView);
        freshersRecyclerView.setHasFixedSize(true);
        freshersRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        convocationRecyclerView=view.findViewById(R.id.convocationRecyclerView);
        convocationRecyclerView.setHasFixedSize(true);
        convocationRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        unifestRecyclerView=view.findViewById(R.id.unifestRecyclerView);
        unifestRecyclerView.setHasFixedSize(true);
        unifestRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
    }
}