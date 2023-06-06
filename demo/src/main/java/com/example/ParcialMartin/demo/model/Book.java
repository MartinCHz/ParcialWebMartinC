package com.example.ParcialMartin.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Iterator;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;


@Entity
@Table(name = "Libro_martinChen")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String title;
    private String reference;
    private String author;
    private Double price;
    private String location;
   
   
    public Book() {
        super();
        this.title = null;
        this.reference = null;
        this.author = null;
        this.price = null;
        this.location = null;
    }

    
    public Book(String title, String reference, String author, Double price, String location) {
        super();
        this.title = title;
        this.reference = reference;
        this.author = author;
        this.price = price;
        this.location = location;
    }


    public Long getId() {
        return id;
    }

    public String gettitle(){
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getreference() {
        return reference;
    }

    public void setreference(String reference) {
        this.reference = reference;
    }

    public String getauthor(){
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public Double getprice() {
        return price;
    }

    public void setprice(Double price) {
        this.price = price;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public void setBook(String title, String reference, String author, Double price, String location) {
		this.title = title;
		this.reference = reference;
		this.author = author;
		this.price = price;
		this.location = location;
	}

    public JSONObject toJSON() throws Exception {
		JSONObject japlicacion = new JSONObject();
		japlicacion.put("id", getId());
		japlicacion.put("title", gettitle());
        japlicacion.put("reference", getreference());
        japlicacion.put("author", getauthor());
		japlicacion.put("price", getprice());
		japlicacion.put("location", getlocation());
		return japlicacion;
	}

	public static JSONArray toJSONArray(Iterable<Book> books) throws Exception {
		JSONArray jbook = new JSONArray();
		Iterator<Book> ibooks = books.iterator();
		while (ibooks.hasNext()) {
			Book book = ibooks.next();
			jbook.put(book.toJSON());
		}

		return jbook;
	}

}
