package reference;

import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reference {
    private RatingRegister register;
    
    public Reference(RatingRegister register) {
        this.register = register;
    }
    
    public Film recommendFilm(Person person) {
        if (register.getPersonalRatings(person).isEmpty()) {
            return generalRecommendation();
        }
        List<Person> reviewers = register.reviewers();
        reviewers.remove(person);
        Map<Person, Integer> similaries = new HashMap<Person, Integer>();
        for (Person testedPerson : reviewers) {
            similaries.put(testedPerson, calculateSimilarity(person, testedPerson));
        }
        Collections.sort(reviewers, new PersonComparator(similaries));
        Person mostSimilar = reviewers.get(0); // first is Thomas (doesn't have similarity)

        Map<Film, Rating> personalRatings = register.getPersonalRatings(person);
        Map<Film, Rating> mostSimilarRatings = register.getPersonalRatings(mostSimilar);
        int maxRating = Rating.BAD.getValue() - 1; // less than the worst rating
        Film bestFilm = null;
        for (Film film : mostSimilarRatings.keySet()) {
            if (!personalRatings.containsKey(film)) {
                if (mostSimilarRatings.get(film).getValue() > maxRating) {
                    maxRating = mostSimilarRatings.get(film).getValue();
                    bestFilm = film;
                }
            }
        }
        return bestFilm;
    }
    
    private Film generalRecommendation() {
        List<Film> films = register.films();
        FilmComparator filmComp = new FilmComparator(register.filmRatings());
        Collections.sort(films, filmComp);
        return films.get(0);
    }
    
    private int calculateSimilarity(Person p1, Person p2) {
        Map<Film, Rating> p1Films = register.getPersonalRatings(p1);
        Map<Film, Rating> p2Films = register.getPersonalRatings(p2);
        int similarity = 0;
        for (Film film : p1Films.keySet()) {
            if (p2Films.containsKey(film)) {
                similarity += p1Films.get(film).getValue() * p2Films.get(film).getValue();
            }
        }
        return similarity;
    }
}
