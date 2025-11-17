package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Movie;

import java.io.IOException;
import java.util.List;

public interface MovieLoader {
    List<Movie> LoadAll() throws IOException;
}
