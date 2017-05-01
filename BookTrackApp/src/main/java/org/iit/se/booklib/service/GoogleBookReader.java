package org.iit.se.booklib.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.iit.se.booklib.dao.BookDao;
import org.iit.se.booklib.model.Book;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleBookReader {

	@Autowired
	BookDao bookDao;

	private String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
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

	public List<Book> getBooksFromGoogleAPI(String bookTitle) {
		List<Book> books = new ArrayList<>();
		try {
			JSONObject json = readJsonFromUrl("https://www.googleapis.com/books/v1/volumes?q=title:" + bookTitle);
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
					amount = "";
				}
				Book book = new Book();
				book.setBookNumber(id.substring(0, Math.min(id.length(), 30)));
				book.setBookAuthor(author.substring(0, Math.min(author.length(), 30)));
				book.setBookName(title.substring(0, Math.min(title.length(), 30)));
				book.setBookPublication(publisher.substring(0, Math.min(publisher.length(), 30)));
				if (StringUtils.isNotEmpty(amount)) {
					book.setBookPrice(new BigDecimal(amount));
				} else {
					book.setBookPrice(new BigDecimal("0.00"));
				}

				books.add(book);
				bookDao.addBook(book, 0, 0);
				System.out.println(id + " " + title + " " + author + " " + publisher + " " + amount);
			}
		} catch (Exception e) {
			System.out.println("Error While reading books from google API");
		}
		return books;
	}
}