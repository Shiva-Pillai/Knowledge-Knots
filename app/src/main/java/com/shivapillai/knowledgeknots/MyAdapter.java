package com.shivapillai.knowledgeknots;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Information_of_upload_docs> uploadPDFList;
    Intent intent;
    DownloadManager manager;
    Context context;
    public MyAdapter(List<Information_of_upload_docs> uploadPDFList) {

        this.uploadPDFList = uploadPDFList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.info_layof_serverfiles,viewGroup,false);
        return new MyViewHolder((view));

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final String name = uploadPDFList.get(position).getFile_name();
        final String url = uploadPDFList.get(position).getUrl();
        final String topic = uploadPDFList.get(position).getTopics();
        final String sub = uploadPDFList.get(position).getSub_name();
        final String ch = uploadPDFList.get(position).getCh_no();
        holder.setData(name,sub,ch,topic);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse(uploadPDFList.get(position).getUrl()));
                //holder.button.getContext().startActivity(intent);


                /////////// Trying To create a new file ///////////
                File file = new File(Environment.getExternalStorageDirectory()+"/"+"Knowledge Pnots");

                //// To check if File is not created
                if (!file.exists())
                {
                    file.mkdir();

                }
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);

                request.setTitle(name);
                request.setDescription("Downloading .... !!!!!!!");

                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                request.setDestinationInExternalPublicDir("Knowledge Knots",name + ".pdf");

                // get the download service and enqueue file

                manager = (DownloadManager) holder.button.getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);




            }
        });

    }


    @Override
    public int getItemCount() {

        return uploadPDFList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView,topics,cp_no,sub_name;
        public Button button;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView = itemView.findViewById(R.id.name);
            button = itemView.findViewById(R.id.download);
            cp_no = itemView.findViewById(R.id.file_ch);
            sub_name = itemView.findViewById(R.id.file_subject);
            topics = itemView.findViewById(R.id.file_topics);

        }


        public void setData(String name,String sub,String ch,String topic)
        {
            textView.setText(name);
            cp_no.setText("Ch - "+ch);
            sub_name.setText(sub);
            topics.setText("Topics - "+topic);
        }


    }
}

