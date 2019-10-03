package com.omelchenkoaleks.starttechopolice._003_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omelchenkoaleks.starttechopolice.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> mMovies;

    public MovieAdapter(List<Movie> movies) {
        mMovies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView mLogoImageView;
        private TextView mNameTextView;
        private TextView mDescriptionTextView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            mLogoImageView = itemView.findViewById(R.id.logo_image_view);
            mNameTextView = itemView.findViewById(R.id.movie_name_text_view);
            mDescriptionTextView = itemView.findViewById(R.id.description_text_view);
        }

        private void bind(Movie movie) {
            mLogoImageView.setImageResource(movie.poster);
            mNameTextView.setText(movie.name);
            mDescriptionTextView.setText(movie.description);
        }
    }


}
