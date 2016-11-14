package data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface JetDAO {

	public Boolean add(Jet jet);

	public Jet get(String tailNumber);

	public Collection<Jet> values();

	public String getTailNumber(String key);

	public Set<String> toList();

	public int size();

	public String[] keyList();

	public Set<String> keySet();

	public String getManufacturer(String key);

	public String getModel(String key);

	public String getPhoto(String key);

	public void displayAll();
	
	public boolean put(Jet jet);
	
	public Jet remove(String tailNumber);

	public HashMap<String, Jet> getHashMap();
}
