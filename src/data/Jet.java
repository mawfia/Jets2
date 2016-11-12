package data;

import java.util.Comparator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Jet implements Comparator<Jet>{

	@NotNull
	@Size(min=2, max=30)
	private String manufacturer;
	@NotNull
	private String model;
	private float speed;
	private float range;
	private float price;
	private int fuelCapacity;
	private String photo;
	private Pilot pilot;
	
	public Jet(){
		this("", "", 0.0F, 0.0F, 0.0F, 0, null, null);
	}
	
	public Jet(String manufacturer, String model, float speed, float range,float price, int fuelCapacity, String photo, Pilot pilot){
		setManufacturer(manufacturer);
		setModel(model);
		setSpeed(speed);
		setRange(range);
		setPrice(price);
		setFuelCapacity(fuelCapacity);
		setPhoto(photo);
		setPilot(pilot);
	}
	
	public float convertToMach(float speedInMPH){
		return speedInMPH*.00130332F;
	}
	
	public String getManufacturer(){
		return this.manufacturer;
	}
	
	public void setManufacturer(String manufacturer){
		if(manufacturer != null && manufacturer.length() > 1) this.manufacturer = manufacturer;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		if(model != null && model.length() > 1) this.model = model;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getRange() {
		return range;
	}

	public void setRange(float range) {
		this.range = range;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int capacity) {
		this.fuelCapacity = capacity;
	}

	public Pilot getPilot() {
		return pilot;
	}
	
	public void setPhoto(String photo){
		if(photo != null) this.photo = "images/" + photo.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase()+"/1.jpg";
		//else if(model != null) this.photo = "/WEB-INF/images/" + this.model.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase()+"/1.jpg";
		else this.photo = "images/"+ "default/"+((int)(Math.random()*8))+".jpg";
	}
	
	public String getPhoto(){
		return this.photo;
	}

	public void setPilot(Pilot pilot) {
		if(pilot != null) this.pilot = pilot;
		else {this.pilot = new Pilot(); this.pilot.setFirstname("N/A"); this.pilot.setLastname("N/A");}
	}
	
	public boolean exists(){
	
		if(this.getModel() == null || this.getModel() == "" || this.getModel().length() == 0 ) return false;
	
		return true;
	}

	
	public void display() {

		if(exists() == true)
		{
			String model = getModel().toUpperCase().substring(0,1) + getModel().substring(1);

			System.out.printf("%-25s (M)%-2.2f/(MPH)%-11d %-10.2f $%-15.2f %-10d\n", model, convertToMach(getSpeed()), (int)getSpeed(), getRange(), (float)getPrice(), getFuelCapacity());
			pilot.display();
		}
	}

	@Override
	public String toString() {
		return "Jet [manufacturer " + manufacturer + " model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + ", capacity="
				+ fuelCapacity + ", pilot=" + pilot + " photo=" + this.photo +"]";
	}

	@Override
	public int compare(Jet o1, Jet o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
