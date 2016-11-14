package data;

import java.io.BufferedReader;
import java.util.concurrent.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;


@Repository
public class JetFileDAO implements JetDAO{

	private static final String AIRCRAFT_FILE = "/WEB-INF/aircraft.csv";
	private HashMap<String, Jet> jets = new HashMap<String, Jet>();

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
				float fuelCapacity = Float.parseFloat(tokens[5]);
				Jet newJet = new Jet(null, manufacturer, model, speed, range, price, fuelCapacity, model, null);
				jets.put(newJet.getTailNumber(), newJet);

			}
			is.close();
			buf.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public Boolean add(Jet jet){
		if(jet.exists()) 
			if(!jets.containsKey(jet.getTailNumber())) { jets.put(jet.getTailNumber(), jet); return true; }
			else return null;	
		
		return false;
	}
	
	@Override
	public void displayAll(){
		for(Jet j: jets.values()) System.out.println(j);

	}
	
	@Override
	public HashMap<String, Jet> getHashMap(){	
		return jets;
	}
	
	@Override
	public Jet get(String tailNumber){
		return jets.get(tailNumber);		
	}
	
	@Override
	public String getPhoto(String key){
		return jets.get(key).getPhoto();
	}
	
	@Override
	public int size(){
		return jets.size();
	}
	
	@Override
	public String getManufacturer(String key){
		return jets.get(key).getManufacturer();
	}
	
	@Override
	public String getTailNumber(String key){
		return jets.get(key).getTailNumber();
	}
	
	
	@Override
	public String getModel(String key){
		return jets.get(key).getModel();
	}

	@Override
	public boolean put(Jet jet){
		if(jets.containsKey(jet.getTailNumber())) 
			for(Jet j : jets.values()) 
				if(j.getTailNumber().equals(jet.getTailNumber())){
					if(jet.getManufacturer() != null && jet.getManufacturer() != j.getManufacturer()) j.setManufacturer(jet.getManufacturer());
					if(jet.getModel() != null && jet.getModel() != j.getModel()) j.setModel(jet.getModel());
					if(jet.getSpeed() > 0 && jet.getSpeed() != j.getSpeed()) j.setSpeed(jet.getSpeed());
					if(jet.getRange() > 0 && jet.getRange() != j.getRange()) j.setRange(jet.getRange());
					if(jet.getPrice() > 0 && jet.getPrice() != j.getPrice()) j.setPrice(jet.getPrice());
					if(jet.getFuelCapacity() > 0 && jet.getFuelCapacity() != j.getFuelCapacity()) j.setFuelCapacity(jet.getFuelCapacity());
					return true;
				}

		return false;
	}
	
//	public boolean remove(Jet jet){
//		return jets.remove(jet);
//	}
//	
//	public Jet[] toArray(){		
//		return (Jet[])jets.toArray();
//	}
//	
	@Override
	public Set<String> toList(){			
		return null;
	}
	
	@Override
	public Set<String> keySet(){
		return jets.keySet();
	}
	
	@Override
	public Collection<Jet> values(){
		return jets.values();
	}
	
	@Override
	public String[] keyList(){
		String[] keyArray = new String[jets.size()];
		int i= 0;
		for(String t: jets.keySet()) {keyArray[i]=t; i++;}
		return keyArray;
	}
//	
//	public boolean updateJet(Jet jet){
//		
//		if(jet.exists())for(Jet j : jets) { if(j.equals(jet)) j=jet; return true;}
//		
//		return false;
//	}
//	
	@Override
	public Jet remove(String tailNumber){
		return jets.remove(tailNumber);
	}
	
	public Integer getIndex(String key){
		int i= 0;
		for(String t: jets.keySet()) {if (t.equals(key)) return i; else i++;}
		
		return null;
	}
}
