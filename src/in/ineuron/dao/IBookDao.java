package in.ineuron.dao;

import java.util.List;

import in.ineuron.dto.Book;

public interface IBookDao {
	
	public String addBook(Book book); //add a book

	public Book searchBook(Integer bid); //search a book using ID

	public String updateBook(Book book); //Update a book using iD

	public String deleteBook(Integer bid); //Delete a book using ID

	public List<Book> getAllBooks(); //Get a list of books in the library
	
	public String autoUpdateBook(String bid);//auto update when libr comfirm return the books
	
}
