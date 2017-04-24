package org.iit.se.booklib.model;

import java.math.BigDecimal;

public class Book {

	private String bookNumber;
	private String bookName;
	private String bookAuthor;
	private BigDecimal bookPrice;
	private String bookPublication;
	private int avilableQuanity;
	private int allocatedQuantity;
	private String courseNumber;
	private String studRequested;

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookPublication() {
		return bookPublication;
	}

	public void setBookPublication(String bookPublication) {
		this.bookPublication = bookPublication;
	}

	public int getAvilableQuanity() {
		return avilableQuanity;
	}

	public void setAvilableQuanity(int avilableQuanity) {
		this.avilableQuanity = avilableQuanity;
	}

	public int getAllocatedQuantity() {
		return allocatedQuantity;
	}

	public void setAllocatedQuantity(int allocatedQuantity) {
		this.allocatedQuantity = allocatedQuantity;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	
	public String getRequested() {
		return studRequested;
	}
	
	public void setRequested(String studRequested) {
		this.studRequested = studRequested;
	}

}
