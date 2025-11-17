package software.ulpgc.kata3.application;

import software.ulpgc.kata3.architecture.model.Movie;
import software.ulpgc.kata3.architecture.io.RemoteMovieLoader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Movie> movies = new RemoteMovieLoader(Main::fromTsv).LoadAll();
        Histogram histogram = new HistogramBuilder(movies).build(m -> (m.year() / 10) * 10);
        System.out.println("Número total de películas: " + movies.size());
        for(Integer bin: histogram){
            System.out.println(bin + ":" + histogram.count(bin));
        }
    }

    private static Movie fromTsv(String str) {
        return fromTsv(str.split("\t"));
    }

    private static Movie fromTsv(String[] split) {
        return new Movie(split[2], toInt(split[5]), toInt(split[7]));
    }

    private static int toInt(String s) {
        if (s.equals("\\N")) return -1;
        return Integer.parseInt(s);
    }
}