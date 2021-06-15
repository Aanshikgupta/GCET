package com.example.gcet.UI.Faculty;

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

import static android.view.View.GONE;

public class FacultyFragment extends Fragment {

    private List<Faculty> directorList, csList, eiList,eceList,itList, eeList, eeeList, ceList, meList;
    private View directorNoData,eceNoData,eiNoData, csNoData, itNoData, eeNoData, eeeNoData, meNoData, ceNoData;
    private RecyclerView directorRecyclerView,eceRecyclerView,eiRecyclerView, csRecyclerView, itRecyclerView, eeRecyclerView, eeeRecyclerView, meRecyclerView, ceRecyclerView;
    private FacultyAdapter facultyAdapter;
    private DatabaseReference databaseReference, tempRef;
    private View view;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_faculty, container, false);
        setView();
        progressBar.setVisibility(View.VISIBLE);
        setAdapters();
        setDirector();
        setCSE();
        setIT();
        setEE();
        setEEE();
        setECE();
        setEI();
        setME();
        setCE();
        progressBar.setVisibility(GONE);

        return view;
    }

    private void setView() {
        progressBar=((AppCompatActivity) getActivity()).findViewById(R.id.pbmain);

        //No Data Layout setView
        directorNoData = view.findViewById(R.id.directorNoData);
        csNoData = view.findViewById(R.id.CSENoData);
        itNoData = view.findViewById(R.id.ITNoData);
        eeeNoData = view.findViewById(R.id.EEENoData);
        eeNoData = view.findViewById(R.id.EENoData);
        ceNoData = view.findViewById(R.id.CENoData);
        meNoData = view.findViewById(R.id.MENoData);
        eceNoData=view.findViewById(R.id.ECENoData);
        eiNoData=view.findViewById(R.id.EINoData);

        //setView recycler views
        directorRecyclerView = view.findViewById(R.id.directorRecyclerView);
        csRecyclerView = view.findViewById(R.id.CSERecyclerView);
        itRecyclerView = view.findViewById(R.id.ITRecyclerView);
        eeRecyclerView = view.findViewById(R.id.EERecyclerView);
        eeeRecyclerView = view.findViewById(R.id.EEERecyclerView);
        ceRecyclerView = view.findViewById(R.id.CERecyclerView);
        meRecyclerView = view.findViewById(R.id.MERecyclerView);
        eceRecyclerView=view.findViewById(R.id.ECERecyclerView);
        eiRecyclerView=view.findViewById(R.id.EIRecyclerView);
    }


    private void setAdapters() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference = databaseReference.child("Faculty");

    }

    private void setCE() {
        ceRecyclerView.setHasFixedSize(true);
        ceRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        tempRef = databaseReference.child("Civil Engineering");
        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                ceList = new ArrayList<>();
                if (!snapshot.exists()) {
                    ceNoData.setVisibility(View.VISIBLE);
                    ceRecyclerView.setVisibility(GONE);
                } else {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        ceList.add(dataSnapshot.getValue(Faculty.class));
                    }
                    facultyAdapter = new FacultyAdapter(view.getContext(), ceList);
                    ceRecyclerView.setAdapter(facultyAdapter);
                    ceRecyclerView.setVisibility(View.VISIBLE);
                    ceNoData.setVisibility(GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(), "Something went wrong, try again!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setME() {
        meRecyclerView.setHasFixedSize(true);
        meRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        tempRef = databaseReference.child("Mechanical Engineering");
        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                meList = new ArrayList<>();
                if (!snapshot.exists()) {
                    meNoData.setVisibility(View.VISIBLE);
                    meRecyclerView.setVisibility(GONE);
                } else {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        meList.add(dataSnapshot.getValue(Faculty.class));
                    }
                    facultyAdapter = new FacultyAdapter(view.getContext(), meList);
                    meRecyclerView.setAdapter(facultyAdapter);
                    meRecyclerView.setVisibility(View.VISIBLE);
                    meNoData.setVisibility(GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(), "Something went wrong, try again!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setEEE() {

        eeeRecyclerView.setHasFixedSize(true);
        eeeRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        tempRef = databaseReference.child("Electrical and Electronics Engineering");
        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                eeeList = new ArrayList<>();
                if (!snapshot.exists()) {
                    eeeNoData.setVisibility(View.VISIBLE);
                    eeeRecyclerView.setVisibility(GONE);
                } else {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        eeeList.add(dataSnapshot.getValue(Faculty.class));
                    }
                    facultyAdapter = new FacultyAdapter(view.getContext(), eeeList);
                    eeeRecyclerView.setAdapter(facultyAdapter);
                    eeeRecyclerView.setVisibility(View.VISIBLE);
                    eeeNoData.setVisibility(GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(), "Something went wrong, try again!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setECE() {

        eceRecyclerView.setHasFixedSize(true);
        eceRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        tempRef = databaseReference.child("Electrical and Electronics Engineering");
        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                eceList = new ArrayList<>();
                if (!snapshot.exists()) {
                    eceNoData.setVisibility(View.VISIBLE);
                    eceRecyclerView.setVisibility(GONE);
                } else {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        eceList.add(dataSnapshot.getValue(Faculty.class));
                    }
                    facultyAdapter = new FacultyAdapter(view.getContext(), eeeList);
                    eceRecyclerView.setAdapter(facultyAdapter);
                    eceRecyclerView.setVisibility(View.VISIBLE);
                    eceNoData.setVisibility(GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(), "Something went wrong, try again!", Toast.LENGTH_LONG).show();
            }
        });

    }


    private void setEI() {

        eiRecyclerView.setHasFixedSize(true);
        eiRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        tempRef = databaseReference.child("Electronics and Instrumentation Engineering");
        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                eiList = new ArrayList<>();
                if (!snapshot.exists()) {
                    eiNoData.setVisibility(View.VISIBLE);
                    eiRecyclerView.setVisibility(GONE);
                } else {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        eiList.add(dataSnapshot.getValue(Faculty.class));
                    }
                    facultyAdapter = new FacultyAdapter(view.getContext(), eiList);
                    eiRecyclerView.setAdapter(facultyAdapter);
                    eiRecyclerView.setVisibility(View.VISIBLE);
                    eiNoData.setVisibility(GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(), "Something went wrong, try again!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setEE() {

        eeRecyclerView.setHasFixedSize(true);
        eeRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        tempRef = databaseReference.child("Electrical Engineering");
        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                eeList = new ArrayList<>();
                if (!snapshot.exists()) {
                    eeNoData.setVisibility(View.VISIBLE);
                    eeRecyclerView.setVisibility(GONE);
                } else {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        eeList.add(dataSnapshot.getValue(Faculty.class));
                    }
                    facultyAdapter = new FacultyAdapter(view.getContext(), eeList);
                    eeRecyclerView.setAdapter(facultyAdapter);
                    eeRecyclerView.setVisibility(View.VISIBLE);
                    eeNoData.setVisibility(GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(), "Something went wrong, try again!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setIT() {

        itRecyclerView.setHasFixedSize(true);
        itRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        tempRef = databaseReference.child("Information Technology");
        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                itList = new ArrayList<>();
                if (!snapshot.exists()) {
                    itNoData.setVisibility(View.VISIBLE);
                    itRecyclerView.setVisibility(GONE);
                } else {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        itList.add(dataSnapshot.getValue(Faculty.class));
                    }
                    facultyAdapter = new FacultyAdapter(view.getContext(), itList);
                    itRecyclerView.setAdapter(facultyAdapter);
                    itRecyclerView.setVisibility(View.VISIBLE);
                    itNoData.setVisibility(GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(), "Something went wrong, try again!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setCSE() {
        csRecyclerView.setHasFixedSize(true);
        csRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        tempRef = databaseReference.child("Computer Science");
        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                csList = new ArrayList<>();
                if (!snapshot.exists()) {
                    csNoData.setVisibility(View.VISIBLE);
                    csRecyclerView.setVisibility(GONE);
                } else {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        csList.add(dataSnapshot.getValue(Faculty.class));
                    }
                    facultyAdapter = new FacultyAdapter(view.getContext(), csList);
                    csRecyclerView.setAdapter(facultyAdapter);
                    csRecyclerView.setVisibility(View.VISIBLE);
                    csNoData.setVisibility(GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(), "Something went wrong, try again!", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void setDirector() {

        directorRecyclerView.setHasFixedSize(true);
        directorRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        tempRef = databaseReference.child("Director");
        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                directorList = new ArrayList<>();
                if (!snapshot.exists()) {
                    directorNoData.setVisibility(View.VISIBLE);
                    directorRecyclerView.setVisibility(GONE);
                } else {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        directorList.add(dataSnapshot.getValue(Faculty.class));
                    }
                    facultyAdapter = new FacultyAdapter(view.getContext(), directorList);
                    directorRecyclerView.setAdapter(facultyAdapter);
                    directorRecyclerView.setVisibility(View.VISIBLE);
                    directorNoData.setVisibility(GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(view.getContext(), "Something went wrong, try again!", Toast.LENGTH_LONG).show();
            }
        });

    }
}