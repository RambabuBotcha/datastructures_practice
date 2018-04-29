package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {

	public static void main(String[] args) throws Exception {

		HttpURLConnectionExample http = new HttpURLConnectionExample();
		//		http.sendGet();
	}
	static String[] getMovieTitles(String substr) throws Exception {

		JSONParser parser = new JSONParser();

		String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		Object obj2 = parser.parse(response.toString());

		JSONObject jsonObject = (JSONObject) obj2;
		long name = (long) jsonObject.get("per_page");
		System.out.println(name);
		JSONArray msg = (JSONArray) jsonObject.get("data");
		Iterator<JSONObject> iterator = msg.iterator();
		while (iterator.hasNext()) {
			JSONObject t=(JSONObject)iterator.next();
			System.out.println(t.get("Title"));
			//System.out.println(iterator.next());
		}
		System.out.println("json obj: "+jsonObject);
		//print result
		System.out.println("--"+response.toString());
		return null;
	}
}
