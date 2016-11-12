package data;

import java.util.ArrayList;

public interface JetDAO {

	public boolean addJet(Jet jet);

	public void displayFleet();

	ArrayList<Jet> getFleet();
}
