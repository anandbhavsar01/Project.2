/**
 *  Tests the Country class by creating multiple objects.
 *  Creates one object of type CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to create objects of type Country class.
 */
public class TestCountry {

	/**
	 * Includes test examples for class Country and CSVReader.
	 */
	public static void main(String[] args) {
		/////////////
		// Data Set 1
		//
		System.out.println("Data Set 1:");

		double[] canada = {0,0,0.05,0.23,0.37,0.75,1.26};
		double[] mexico = {0,0,0,0,0,0,0.01};
		double[] usa = {0,0,0.14,0.28,0.5,0.83,1.39};

		int numCountries = 3;
		int startingYear = 1983;

		// Create and set objects of type Country 
		//
		Country [] countries;
		countries = new Country[3];
		int countriesIndex = 0;

		Country current;

		current = new Country("canada", canada.length);
		for (int i = 0; i < canada.length; i++)
		{
			current.addSubscriptionYear((startingYear + i), canada[i]);
		}
		countries[countriesIndex] = current;
		countriesIndex++;
		
		current = new Country("mexico", mexico.length);
		for (int i = 0; i < mexico.length; i++)
		{
			current.addSubscriptionYear((startingYear + i), mexico[i]);
		}
		countries[countriesIndex] = current;
		countriesIndex++;
		
		current = new Country("usa", usa.length);
		for (int i = 0; i < usa.length; i++)
		{
			current.addSubscriptionYear((startingYear + i), usa[i]);
		}
		countries[countriesIndex] = current;
		countriesIndex++;
		
		// NOTE REGARDING OUTPUT OF PART 1 "countries"
		// You may format the data as you see fit as long as subscriptions follow year and it is readable.
		// the output is:
		// [your data table]
		
		System.out.printf("usa (1983 to 1989): %.2f \n\n", countries[0].getNumSubscriptionsForPeriod(1983,1989));
		// the output is: usa (1983 to 1989): 2.66 

		System.out.printf("mexico (1983 to 1989): %.2f \n\n", countries[1].getNumSubscriptionsForPeriod(1983,1989));
		// the output is: mexico (1983 to 1989): 0.01 
		
		System.out.printf("canada (2013 to 2020): %.2f \n\n", countries[2].getNumSubscriptionsForPeriod(2013,2020));
		// testing out-of-bounds data
		// the output is: ERROR : requested period between 2013 and 2020 is out of bounds.
		//                        ERROR: Valid years are 2013 and 2020
		//                        canada (2013 to 2020): -1.00 
		
		
		/////////////
		// Data Set 2
		//
		System.out.println("Data Set 2:");

		final String FILENAME = "data/cellular.csv";

		CSVReader parser = new CSVReader(FILENAME);

		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] dataTable = parser.getParsedTable();		

		// Create and set objects of type Country 
		//
		countries = new Country[countryNames.length];
		
		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
		{
			int numberOfYears = yearLabels.length;   // OR numberOfYears = dataTable[countryIndex].length;

			current = new Country(countryNames[countryIndex], numberOfYears);
					
			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
			{
				double [] tmp = dataTable[countryIndex];
				double data = tmp[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], data);
			}
			countries[countryIndex] = current;
		}
			
		
		System.out.printf(countryNames[0] + " (1960 to 2012): %.2f \n", countries[0].getNumSubscriptionsForPeriod(1960,2012));
		// the output is: Aruba (1960 to 2012): 1170.50 

		System.out.printf(countryNames[100] + " (1960 to 2012): %.2f \n", countries[100].getNumSubscriptionsForPeriod(1960,2012));
		// the output is: Hungary (1960 to 2012): 1246.58 
		
		System.out.printf(countryNames[200] + " (1960 to 2012): %.2f \n", countries[200].getNumSubscriptionsForPeriod(1960,2012));
		// the output is: Singapore (1960 to 2012): 1582.80
	}
}
