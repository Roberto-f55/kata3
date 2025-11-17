package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Movie;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class RemoteMovieLoader implements MovieLoader{

    @Override
    public List<Movie> LoadAll() throws IOException {
        return LoadFrom(new URL("https://datasets.imdbws.com/title.basics.tsv.gz"));
    }

    private List<Movie> LoadFrom(URL url) throws IOException {
        return LoadFrom(url.openConnection());
    }

    private List<Movie> LoadFrom(URLConnection connection) throws IOException {
        try (InputStream is = unzip(connection.getInputStream())){
            return LoadFrom(is);

        }
    }

    private List<Movie> LoadFrom(InputStream is) throws IOException {
        return LoadFrom(new BufferedReader(new InputStreamReader(is)));
    }

    private List<Movie> LoadFrom(BufferedReader reader) throws IOException {
        MovieParser parser = new TsvMovieParser();
        List<Movie> movies = new ArrayList<>();
        reader.readLine();
        while (true){
            String line = reader.readLine();
            if (line == null) break;
            movies.add(parser.parse(line));
        }
        return movies;
    }

    private InputStream unzip(InputStream is) throws IOException {
        return new GZIPInputStream(new BufferedInputStream(is, 4096));
    }
}