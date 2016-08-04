package michael.com.zaplabs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import michael.com.zaplabs.R;
import michael.com.zaplabs.model.Photo;


/**
 * Created by Mikhail on 8/3/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<Photo> objectPhotos;
    private Context context;


    public MyAdapter(List<Photo> objectPhotos) {
        this.objectPhotos = objectPhotos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImage;
        public TextView mText;


        public ViewHolder(View v) {
            super(v);

            mText = (TextView) v.findViewById(R.id.object_name);
            mImage = (ImageView) v.findViewById(R.id.object_img);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_main, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Photo data = objectPhotos.get(position);
        bindData(data, holder);

    }


    private void bindData(final Photo data, ViewHolder holder) {

        holder.mText.setText(data.getId() + " - " + data.getTitle());

        Glide.with(context).load(data.getImage())
                .placeholder(R.drawable.placeholder)
                .into(holder.mImage);

    }


    @Override
    public int getItemCount() {
        return objectPhotos.size();
    }
}
