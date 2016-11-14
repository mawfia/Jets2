package data;

import java.util.Comparator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Jet implements Comparator<Jet>{

//	@NotNull
	private String tailNumber;
//	@NotNull
//	@Size(min=2, max=30)
	private String manufacturer;
//	@Size(min=2, max=30)
//	@NotNull
	private String model;
	private float speed;
	private float range;
	private float price;
	private float fuelCapacity;
	private String photo;
	private Pilot pilot;
	
	public Jet(){
		//this( "", "", "", 0.0F, 0.0F, 0.0F, 0.0F);
		System.out.println("using no ags constructor");		
	}
	
	public Jet(String tailNumber, String manufacturer, String model, float speed, float range,float price, float fuelCapacity){
		this(tailNumber, manufacturer, model, speed, range, price, fuelCapacity, null, null);

	}
	
	public Jet( String tailNumber, String manufacturer, String model, float speed, float range,float price,float fuelCapacity, String photo, Pilot pilot){
		setManufacturer(manufacturer);
		setModel(model);
		setSpeed(speed);
		setRange(range);
		setPrice(price);
		setFuelCapacity(fuelCapacity);
		setPhoto(photo);
		setPilot(pilot);
		setTailNumber(tailNumber);

	}
	
	public String getTailNumber() {
		return this.tailNumber;
	}

	public void setTailNumber(String tailNumber) {	
		
		if(tailNumber != null && tailNumber != "") {
			this.tailNumber = tailNumber.toUpperCase();
		}
		else {
			String newModel = this.model.toUpperCase().replaceAll("[^A-Z01-9 ]", "");
			this.tailNumber = (""+ newModel.charAt( ((int)(Math.random()*newModel.length())) ) + Math.abs(this.hashCode())/100000).trim();

		}
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
		return this.speed;
	}

	public void setSpeed(float speed) {
		if(speed >=0 && speed < 10000) this.speed = speed;
		else this.speed = 0.0F;
	}

	public float getRange() {
		return this.range;
	}

	public void setRange(float range) {
		this.range = range;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		if(price >= 0 && price < 20000) this.price = price;
		else this.price = 0.0F;
	}

	public float getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(float fuelCapacity) {
		if(fuelCapacity >= 0 && fuelCapacity < 20000) this.fuelCapacity = fuelCapacity; 
		else this.fuelCapacity = 0.0F;
	}

	public Pilot getPilot() {
		return this.pilot;
	}
	
	public void setPilot(Pilot pilot) {
		
		
		if(pilot != null) this.pilot = pilot;  //Does not work with if(!pilot.exists())
		else {this.pilot = new Pilot(); this.pilot.setFirstname("N/A"); this.pilot.setLastname("N/A");}
	}
	
	public void setPhoto(String photo){
		if(photo != null && photo !="") this.photo = "images/" + photo.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase()+"/1.jpg";
		//else if(model != null) this.photo = "/WEB-INF/images/" + this.model.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase()+"/1.jpg";
		else this.photo = "images/"+ "default/"+((int)(Math.random()*8))+".jpg";
	}
	
	public String getPhoto(){
		return this.photo;
	}

	
	public boolean exists(){
	
		if(this.tailNumber == null || this.tailNumber.equals("") || this.tailNumber.length() < 2) return false;
		if(this.manufacturer == null || this.manufacturer.equals("") || this.manufacturer.length() < 2 ) return false;
		if(this.model == null || this.model.equals("") || this.model.length() < 1 ) return false;
	
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
		return "Jet [tailNumber=" + tailNumber + " manufacturer " + manufacturer + " model=" + model + ", speed=" + speed + ", range=" + range + ", "
				+ "price=" + price + ", fuel capacity=" + this.fuelCapacity + ", pilot=" + pilot + " photo=" + this.photo +"]";
	}

	@Override
	public int compare(Jet o1, Jet o2) {
		//return o1.manufacturer.compareTo(o2.manufacturer) == 0 ? o1.model.compareTo(o2.model) == 0 ? o1.tailNumber.compareTo(o2.tailNumber) : 1 : 0;
		if(o1.manufacturer.compareTo(o2.manufacturer) == 0)
			if(o1.model.compareTo(o2.model) == 0) return o1.tailNumber.compareTo(o2.tailNumber);
			else return o1.model.compareTo(o2.model);
		else return o1.manufacturer.compareTo(o2.manufacturer);
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + Float.floatToIntBits(range);
		result = prime * result + Float.floatToIntBits(speed);
		result = prime * result + Float.floatToIntBits(fuelCapacity);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Jet other = (Jet)obj;
		
		return this.tailNumber.equals(other.tailNumber);
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Jet other = (Jet) obj;
//		if (fuelCapacity != other.fuelCapacity)
//			return false;
//		if (manufacturer == null) {
//			if (other.manufacturer != null)
//				return false;
//		} else if (!manufacturer.equals(other.manufacturer))
//			return false;
//		if (model == null) {
//			if (other.model != null)
//				return false;
//		} else if (!model.equals(other.model))
//			return false;
//		if (photo == null) {
//			if (other.photo != null)
//				return false;
//		} else if (!photo.equals(other.photo))
//			return false;
//		if (pilot == null) {
//			if (other.pilot != null)
//				return false;
//		} else if (!pilot.equals(other.pilot))
//			return false;
//		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
//			return false;
//		if (Float.floatToIntBits(range) != Float.floatToIntBits(other.range))
//			return false;
//		if (Float.floatToIntBits(speed) != Float.floatToIntBits(other.speed))
//			return false;
//		if (tailNumber == null) {
//			if (other.tailNumber != null)
//				return false;
//		} else if (!tailNumber.equals(other.tailNumber))
//			return false;
//		return true;
	}

	
}
