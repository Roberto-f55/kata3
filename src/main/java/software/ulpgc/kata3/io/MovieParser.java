package software.ulpgc.kata3.io;

import software.ulpgc.kata3.model.Movie;

public interface MovieParser {
    Movie parse(String str);
}
