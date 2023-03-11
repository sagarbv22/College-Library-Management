package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.Borrow;
import in.ineuron.dto.Librarian;

public interface ILibrarianService {
	
	public Librarian getLibrarian(String userName); //get the libr credentials
	
	  public String addReturnRequest(Borrow borrow); //add the book return request to Db
	  
	  public String deleteReturnRequest(String sid, Integer bid); //Delete the return request when libr accepted.
	  
	  public List<Borrow> selectReturnRequest();//Selecting all return requests
}
