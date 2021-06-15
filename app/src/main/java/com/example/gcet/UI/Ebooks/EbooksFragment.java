package com.example.gcet.UI.Ebooks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class EbooksFragment extends Fragment {

    private View view;
    private DatabaseReference databaseReference,ref;
    private RecyclerView ebookRecyclerView;
    private List<Ebook> ebookList;
    private EbookAdapter adapter;


    public EbooksFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_ebooks, container, false);

        ebookRecyclerView=view.findViewById(R.id.ebookRecyclerView);
        setFirebase();
        ebookRecyclerView.setHasFixedSize(true);
        ebookRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getAllData();


        return view;
    }

    private void setFirebase() {
        databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference=databaseReference.child("Ebooks");
        ref=databaseReference;
    }

    private void getAllData() {

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                ebookList=new ArrayList<>();
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                    ebookList.add(dataSnapshot.getValue(Ebook.class));
                adapter=new EbookAdapter(getContext(),ebookList);
                adapter.notifyDataSetChanged();
                ebookRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(),"Something went wrong, please try again!",Toast.LENGTH_LONG).show();
            }
        });

    }
}