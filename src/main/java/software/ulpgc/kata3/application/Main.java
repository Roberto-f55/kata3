package software.ulpgc.kata2.application;

import software.ulpgc.kata2.model.Movie;
import software.ulpgc.kata2.io.RemoteMovieLoader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Movie> movies = new RemoteMovieLoader().LoadAll();
        System.out.println(movies.size()
        );
    }
}
