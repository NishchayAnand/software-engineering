package Service;

import DAO.Location;
import DAO.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements MovieService {
    @Override
    public List<Movie> getMovies(Location location) {
        return new ArrayList<>();
    }
}
