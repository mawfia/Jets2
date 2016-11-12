package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class ImageFileDAO implements ImageDAO {

	private static final String BING_TEST_FILE = "/WEB-INF/input.txt";
	private static final String HANGER_URL = "http://www.bing.com/cr?";
	private ArrayList<String> iDAO = new ArrayList<String>();

	@Autowired 
	private WebApplicationContext wac;
	//https://api.cognitive.microsoft.com/bing/v5.0/images/search?q=nature&count=10&offset=0&mkt=en-us&safeSearch=Moderate&size=wallpaper&q=colorado&subscription-key=f356762f977b46ae9133115d67e2411c
	
	@PostConstruct
	public void init(){
		try (	InputStream is = wac.getServletContext().getResourceAsStream(BING_TEST_FILE);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
				Pattern p = Pattern.compile("(\"contentUrl.{30}[?]?)(\\S+\")");
			
				String line;
				while((line = buf.readLine()) != null) {
					Matcher m = p.matcher(line);
					while (m.find()) { iDAO.add(HANGER_URL + m.group(2).substring(0, m.group(2).length()-1)); }
			}
			is.close();
			buf.close();
			
		} catch (IOException e) {
			System.err.println(e);
		}

	}
	
	@Override
	public String getImageDAO(int index){
		if(index >=0 && index < iDAO.size()) return iDAO.get(index);
		else return null;
	}
	
	@Override
	public ArrayList<String> getiDAO() {
		return iDAO;
	}
	
	@Override
	public String getIndex(int i) {
		return iDAO.get(i);
	}

	@Override
	public void setiDAO(ArrayList<String> iDAO) {
		this.iDAO = iDAO;
	}
	
	

	
}
