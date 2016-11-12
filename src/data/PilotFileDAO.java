package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class PilotFileDAO {

	private static final String PILOT_FILE = "/WEB-INF/pilots.csv";
	private ArrayList<Pilot> pilots = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;

	
	@PostConstruct
	public void init() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(PILOT_FILE);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {

			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String fname = tokens[0].trim();
				String mname = tokens[1].trim();
				String lname = tokens[2].trim();
				int age = Integer.parseInt(tokens[3]);
				int experience = Integer.parseInt(tokens[4]);
				pilots.add(new Pilot(fname, mname, lname, age, experience));
			}
			is.close();
			buf.close();
			//System.out.println(pilots.get(0));

		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
}
