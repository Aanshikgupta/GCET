package com.example.gcet.UI.Notice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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


public class NoticeFragment extends Fragment {

    private RecyclerView noticeRecyclerView;
    private DatabaseReference databaseReference;
    private List<Notice> notices;
    private View view;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_notice, container, false);
        progressBar=((AppCompatActivity) getActivity()).findViewById(R.id.pbmain);
        noticeRecyclerView=view.findViewById(R.id.noticeRecyclerView);
        setFirebase();
        return view;
    }

    private void setFirebase() {
        databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference=databaseReference.child("Notices");
        DatabaseReference ref=databaseReference;
        notices=new ArrayList<>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    notices.add(0, dataSnapshot.getValue(Notice.class));
                }
                NoticeAdapter adapter = new NoticeAdapter(view.getContext(), notices);
                noticeRecyclerView.setHasFixedSize(true);
                adapter.notifyDataSetChanged();
                noticeRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                noticeRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(),"Something went wrong, please try again!",Toast.LENGTH_LONG).show();
            }
        });
    }
}