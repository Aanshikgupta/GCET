package com.example.gcet.UI.Faculty;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gcet.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder> {

    Context context;
    List<Faculty> faculties;

    public FacultyAdapter(Context context, List<Faculty> faculties) {
        this.context = context;
        this.faculties = faculties;

    }

    public FacultyAdapter() {
    }




    @NonNull
    @NotNull
    @Override
    public FacultyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.faculty_item,parent,false);
        return new FacultyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FacultyViewHolder holder, int position) {
        Faculty faculty= faculties.get(position);
        holder.facultyName.setText(faculty.getFacultyName());
        holder.facultyEmail.setText(faculty.getFacultyEmail());
        holder.facultyPost.setText(faculty.getFacultyPost());
        String url=faculty.getImageUrl();
        Log.i("TAG",faculty.getFacultyDepartment()+"--->"+url.equalsIgnoreCase(""));
        if(!(url.equalsIgnoreCase("")))
            Glide.with(context).load(faculty.getImageUrl()).into(holder.facultyImage);


    }

    @Override
    public int getItemCount() {
        return faculties.size();
    }

    public class FacultyViewHolder extends RecyclerView.ViewHolder{

        TextView facultyName,facultyEmail,facultyPost,updateFacultyItem;
        CircleImageView facultyImage;
        public FacultyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            facultyName=itemView.findViewById(R.id.facultyItemName);
            facultyEmail=itemView.findViewById(R.id.facultyItemEmail);
            facultyPost=itemView.findViewById(R.id.facultyItemPost);
            facultyImage=itemView.findViewById(R.id.facultyItemImage);
        }
    }
}
