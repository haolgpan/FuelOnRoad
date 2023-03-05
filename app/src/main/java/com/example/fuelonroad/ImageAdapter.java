package com.example.fuelonroad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<Integer> mImages;
    private NavController mNavController;

    public ImageAdapter(List<Integer> images, NavController navController) {
        mImages = images;
        mNavController = navController;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.bind(mImages.get(position));
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another fragment
                mNavController.navigate(R.id.action_vehiculosFragment_to_vehiculosModFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public void deleteItem(int position) {
        mImages.remove(position);
        notifyItemRemoved(position);
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
        }

        public void bind(int imageResId) {
            mImageView.setImageResource(imageResId);
        }
    }
}


