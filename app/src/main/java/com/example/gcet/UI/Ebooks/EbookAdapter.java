package com.example.gcet.UI.Ebooks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gcet.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewHolder> {

    Context context;
    List<Ebook> ebooks;

    public EbookAdapter() {
    }

    public EbookAdapter(Context context, List<Ebook> ebooks) {
        this.context = context;
        this.ebooks = ebooks;
    }

    @NonNull
    @NotNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ebook_item,parent,false);
        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EbookAdapter.EbookViewHolder holder, int position) {
        Ebook ebook= ebooks.get(position);
        holder.pdfTitle.setText(ebook.getPdfTitle());

        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(ebook.getPdfUrl()));
                    context.startActivity(intent);
                    Toast.makeText(context,"Downloading...",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(context,"Something went wrong, try again!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ebooks.size();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {
        TextView pdfTitle;
        ImageView ebookDownload;
        public EbookViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            pdfTitle=itemView.findViewById(R.id.ebookItemTitle);
            ebookDownload=itemView.findViewById(R.id.downloadEbookItem);
        }
    }
}
