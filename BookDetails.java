package com.bhaiti.server.main;

public class BookDetails {

	private String bookName;
	private String bookAuthor;
	private Float bookPrice;
	private Float minBookPrice;
	private Float maxBookPrice;
	
	public Float getMinBookPrice() {
		return minBookPrice;
	}
	public void setMinBookPrice(Float minBookPrice) {
		this.minBookPrice = minBookPrice;
	}
	public Float getMaxBookPrice() {
		return maxBookPrice;
	}
	public void setMaxBookPrice(Float maxBookPrice) {
		this.maxBookPrice = maxBookPrice;
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
	public Float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public BookDetails BookDetails(String bookName, Double bookPrice, String bookAuthor) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
