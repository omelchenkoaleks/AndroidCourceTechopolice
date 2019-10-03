package com.omelchenkoaleks.starttechopolice._003_recycler_view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.omelchenkoaleks.starttechopolice.R;

import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {
    private List<Movie> mMovies;
    private MovieAdapter mMovieAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        mMovies = generateMovieList();
        setupRecyclerView();
        setupFabButton();
    }

    private void onAddClick() {
        mMovies.add(generateNewMovie());
        mMovieAdapter.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mMovieAdapter = new MovieAdapter(mMovies,this::onMovieClick);

        mRecyclerView.setAdapter(mMovieAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void onMovieClick(Movie movie) {
        Toast.makeText(this, movie.name, Toast.LENGTH_SHORT).show();
    }

    private List<Movie> generateMovieList() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Побег из Шоушенка",
                "Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни",
                R.drawable.movie_1));
        movies.add(new Movie("Матрица",
                "Жизнь Томаса Андерсона разделена на две части: днём он — самый обычный офисный работник, получающий нагоняи от начальства, а ночью превращается в хакера по имени Нео, и нет места в сети, куда он не смог бы дотянуться",
                R.drawable.movie_2));
        movies.add(new Movie("Как приручить дракона",
                "Вы узнаете историю подростка Иккинга, которому не слишком близки традиции его героического племени, много лет ведущего войну с драконами",
                R.drawable.movie_3));
        movies.add(new Movie("12 стульев",
                "Во время революции и последовавшего за ней краткого периода военного коммунизма многие прятали свои ценности как можно надежнее",
                R.drawable.movie_4));
        movies.add(new Movie("Зеленая книга",
                "Утонченный светский лев, богатый и талантливый музыкант нанимает в качестве водителя и телохранителя человека, который менее всего подходит для этой работы",
                R.drawable.movie_5));
        movies.add(new Movie("Пираты Карибского моря: Проклятие Черной жемчужины",
                "Жизнь харизматичного авантюриста, капитана Джека Воробья, полная увлекательных приключений, резко меняется, когда его заклятый враг — капитан Барбосса — похищает корабль Джека, Черную Жемчужину, а затем нападает на Порт Ройал и крадет прекрасную дочь губернатора, Элизабет Свонн.",
                R.drawable.movie_6));
        movies.add(new Movie("Гарри Поттер и философский камень",
                "Жизнь десятилетнего Гарри Поттера нельзя назвать сладкой: его родители умерли, едва ему исполнился год, а от дяди и тётки, взявших сироту на воспитание, достаются лишь тычки да подзатыльники",
                R.drawable.movie_7));
        return movies;
    }

    private void setupFabButton() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddClick();
            }
        });
    }

    private Movie generateNewMovie() {
        return new Movie("New movie!!!", "Description will be added later!!!", 0);
    }
}
