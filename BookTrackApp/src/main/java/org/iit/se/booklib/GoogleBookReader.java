package org.iit.se.booklib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleBookReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static void main(String[] args) throws IOException, JSONException {
		JSONObject json = readJsonFromUrl("https://www.googleapis.com/books/v1/volumes?q=title:Code");
		System.out.println(json.toString());
		System.out.println(json.get("items"));
		JSONArray jsonarray = json.getJSONArray("items");
		for (int i = 0; i < jsonarray.length(); i++) {
			JSONObject jsonobject = jsonarray.getJSONObject(i);
			JSONObject volumeInfo = (JSONObject) jsonobject.get("volumeInfo");
			String id = jsonobject.getString("id");
			String title = volumeInfo.getString("title");
			String publisher = "";
			if (volumeInfo.has("publisher")) {
				publisher = volumeInfo.getString("publisher");
			}
			String author = "";
			if (volumeInfo.has("authors")) {
				author = (String) volumeInfo.getJSONArray("authors").get(0);
			}

			JSONObject salesInfo = (JSONObject) jsonobject.get("saleInfo");
			String amount = "";
			if (salesInfo.has("retailPrice")) {
				JSONObject retailPrice = (JSONObject) salesInfo.get("retailPrice");
				if (retailPrice.has("amount")) {
					amount = String.valueOf(retailPrice.get("amount"));
				}
			} else {
				amount = "not for sale";
			}

			System.out.println(id + " " + title + " " + author + " " + publisher+ " " + amount);
		}
	}
}