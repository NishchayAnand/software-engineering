package Service;

import DAO.Address;
import DAO.Location;
import DAO.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> getMovies(Location location);
}
