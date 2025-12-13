

import java.util.Comparator;
public class Exercise1 {

   public static void main(String[] args) {
      // highest populated city of each country
      InMemoryWorldDao worldDao = InMemoryWorldDao.getInstance();

worldDao.getCountries().values().forEach(country -> 
    country.getCities().stream()
     .max(Comparator.comparingInt(c -> c.getPopulation()))
     .ifPresent(city -> System.out.println(country.getCode() + ": " + city.getName() + " (" + city.getPopulation() + ")"))
);
/* 
worldDao.getCountries().values().stream()
    .map(country -> country.getCities().stream().max(Comparator.comparingInt(City::getPopulation)).orElse(null))
    .filter(city -> city != null)
    .sorted(Comparator.comparingInt(City::getPopulation).reversed())
    .forEach(city -> System.out.println(city.getName() + " (" + city.getPopulation() + ")"));

*/
   }

}