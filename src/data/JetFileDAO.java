package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;

@Repository
public class JetFileDAO implements JetDAO{

	private static final String AIRCRAFT_FILE = "/WEB-INF/aircraft.csv";
	private ArrayList<Jet> jets = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;

	
	@PostConstruct
	public void init() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(AIRCRAFT_FILE);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {

			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String manufacturer = tokens[0].trim();
				String model = tokens[1].trim();
				float speed = Float.parseFloat(tokens[2]);
				float range = Float.parseFloat(tokens[3]);
				float price = Float.parseFloat(tokens[4]);
				int fuelCapacity = Integer.parseInt(tokens[5]);
				jets.add(new Jet(manufacturer, model, speed, range, price, fuelCapacity, model, null));
			}
			is.close();
			buf.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public boolean addJet(Jet jet){
		return jets.add(jet);
	}
	
	@Override
	public void displayFleet(){
		for(Jet j: jets) System.out.println(j);
	}
	
	@Override
	public ArrayList<Jet> getFleet()
	{
		return jets;
	}
	
	
}
