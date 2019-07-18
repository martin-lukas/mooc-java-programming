package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.*;

public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;
    private Map<Film, Double> averages;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
        this.averages = calculateAverages();
    }
    
    private double averageRating(Film film) {
        if (ratings.containsKey(film)) {
            List<Rating> filmRatings = ratings.get(film);
            return average(filmRatings);
        }
        return 0;
    }
    
    private double average(List<Rating> ratingList) {
        int sum = 0;
        for (Rating rating : ratingList) {
            sum += rating.getValue();
        }
        double average = ((double) sum) / ratingList.size();
        return average;
    }
    
    private Map<Film, Double> calculateAverages() {
        Map<Film, Double> averages = new HashMap<Film, Double>();
        for (Film film : ratings.keySet()) {
            averages.put(film, averageRating(film));
        }
        return averages;
    }
    
    @Override
    public int compare(Film f1, Film f2) {
        if (ratings.containsKey(f1) && ratings.containsKey(f2)) {
            double averageComparison = averages.get(f2) - averages.get(f1);
            if (averageComparison > 0) {
                return 1;
            }
            if (averageComparison < 0) {
                return -1;
            }
        }
        return 0;
    }
}
