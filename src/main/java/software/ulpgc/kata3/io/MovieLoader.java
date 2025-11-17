package software.ulpgc.kata3.io;

import software.ulpgc.kata3.model.Movie;

import java.io.IOException;
import java.util.List;

public interface MovieLoader {
    List<Movie> LoadAll() throws IOException;
}
