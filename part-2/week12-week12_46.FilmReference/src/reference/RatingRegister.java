package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class RatingRegister {
    private Map<Film, List<Rating>> ratings = new HashMap<Film, List<Rating>>();
    private Map<Person, Map<Film, Rating>> personalRatings = new HashMap<Person, Map<Film, Rating>>();
    
    public RatingRegister() {}
    
    public void addRating(Film film, Rating rating) {
        if (!ratings.containsKey(film)) {
            ratings.put(film, new ArrayList<Rating>());
        }
        ratings.get(film).add(rating);
    }
    
    public List<Rating> getRatings(Film film) {
        return ratings.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return ratings;
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        if (!ratings.containsKey(film)) {
            ratings.put(film, new ArrayList<Rating>());
        }
        if (!personalRatings.containsKey(person)) {
            personalRatings.put(person, new HashMap<Film, Rating>());
        }
        ratings.get(film).add(rating);
        personalRatings.get(person).put(film, rating);
    }
    
    public Rating getRating(Person person, Film film) {
        if (personalRatings.get(person).containsKey(film)) {
            return personalRatings.get(person).get(film);
        }
        return Rating.NOT_WATCHED;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (personalRatings.containsKey(person)) {
            return personalRatings.get(person);
        }
        return new HashMap<Film, Rating>();
    }
    
    public List<Person> reviewers() {
        List<Person> reviewers = new ArrayList<Person>(personalRatings.keySet());
        return reviewers;
    }
    
    public List<Film> films() {
        List<Film> films = new ArrayList<Film>(ratings.keySet());
        return films;
    }
}
