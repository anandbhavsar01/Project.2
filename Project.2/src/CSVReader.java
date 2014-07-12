import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
	private String[] countryNames;
	private int[] yearLabels;
	private int numberOfCountries;
	private double[][] cellularDataTable;
	private File f;
	private Scanner s;

	public CSVReader(String fILENAME) {
		f = new File("data/cellular.csv");
		try {
			s = new Scanner(f).useDelimiter("\\s*,\\s*");
		} catch (FileNotFoundException e) {
			f = new File("data/cellular.csv");
			System.out.println(e);
		}
		yearLabels = new int[52];
		cellularDataTable = new double[252][52];
		while (s.hasNextLine()) {
			if (s.next().equals("Number of countries")) {
				s.skip("Number of countries");
				String number = s.next();
				numberOfCountries = Integer.parseInt(number);
				countryNames = new String[numberOfCountries];
				s.nextLine();
			}
			for (int i = 0; i < yearLabels.length; i++) {
				if (s.hasNext()) {
					try {
						yearLabels[i] = Integer.parseInt(s.next());
					} catch (NumberFormatException e) {
						continue;
					}
				}
			}
		}
	}

	public String[] getCountryNames() {
		// TODO Auto-generated method stub
		return countryNames;
	}

	public int[] getYearLabels() {
		// TODO Auto-generated method stub
		return yearLabels;
	}

	public double[][] getParsedTable() {
		// TODO Auto-generated method stub
		return cellularDataTable;
	}

}
