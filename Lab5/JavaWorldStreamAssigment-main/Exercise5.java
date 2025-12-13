



//import java.util.Objects;
//import java.util.Optional;

//import static java.lang.System.out;
//import static java.util.Comparator.comparing;
//import static java.util.stream.Collectors.maxBy;

import java.util.Comparator;

public class Exercise5 {

    public static void main(String[] args) {

            InMemoryWorldDao worldDao = InMemoryWorldDao.getInstance();
                // Find the highest populated capital city

   worldDao.getCountries().values().stream()
    .map(country -> country.getCities().stream()
        .filter(city -> city.getId() == country.getCapital()))
    .flatMap(s -> s)
    .max(Comparator.comparingInt(City::getPopulation))
    .ifPresent(city -> System.out.println("Highest populated capital: " +
                                          city.getName() + " (" + city.getPopulation() + ")"));



}
}