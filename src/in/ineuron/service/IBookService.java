package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.Book;

public interface IBookService {
	   
	public String addBook(Book book); //add the book
	
	public Book searchBook(Integer bid); //search a book using ID
    
	public String updateBook(Book book); //update a book using ID
	
	public String deleteBook(Integer bid);//Delete book using ID
	
	public  List<Book> getAllBooks(); //Get a list of all books in library
	
	public String autoUpdateBook(String bid);//auto update when libr comfirm return the books
	
}