import java.util.Map;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) {
            InMemoryWorldDao worldDao = InMemoryWorldDao.getInstance();

  //     Find the most populated city of each continent

Map<String, City> mostPopulatedCityPerContinent =
        worldDao.getCountries().values().stream()

        .flatMap(country -> country.getCities().stream()
                .map(city -> Map.entry(country.getContinent(), city)))
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (c1, c2) -> c1.getPopulation() >= c2.getPopulation() ? c1 : c2
        ));

mostPopulatedCityPerContinent.forEach((continent, city) ->
        System.out.println(continent + ": " + city.getName() + " (" + city.getPopulation() + ")")
);

    }}
