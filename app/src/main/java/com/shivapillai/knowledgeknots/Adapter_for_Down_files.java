package com.shivapillai.knowledgeknots;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Adapter_for_Down_files extends RecyclerView.Adapter<Adapter_for_Down_files.System_file_holder> {


    Context context;
    ArrayList<Info_Downloaded_notes> info_downloaded_notes;

    public Adapter_for_Down_files(Context context, ArrayList<Info_Downloaded_notes> info_downloaded_notes) {
        this.context = context;
        this.info_downloaded_notes = info_downloaded_notes;
    }

    @NonNull
    @Override
    public System_file_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.view_downloaded_files,parent,false);
        return new System_file_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final System_file_holder holder, int position) {

        final Info_Downloaded_notes notes = info_downloaded_notes.get(position);
        holder.filename.setText(notes.getName().toString());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,"Clciked",Toast.LENGTH_SHORT).show();
                //File file = new File(notes.getPath());
                Intent intent = new Intent(context,PDFViewer.class);
                intent.putExtra("Path",notes.getPath());
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.linearLayout.getContext().startActivity(intent);
                Toast.makeText(context,notes.getPath(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return info_downloaded_notes.size();
    }


    public class System_file_holder extends RecyclerView.ViewHolder {

        TextView filename;
        LinearLayout linearLayout;


        public System_file_holder(@NonNull View itemView) {
            super(itemView);

            filename = itemView.findViewById(R.id.name);
            linearLayout = itemView.findViewById(R.id.sys_linear_layout);

        }
    }
}
