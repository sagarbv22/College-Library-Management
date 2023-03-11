package in.ineuron.dao;

import java.util.List;

import in.ineuron.dto.Borrow;
import in.ineuron.dto.Librarian;

public interface ILibrarianDao {
	
  public Librarian getLibrarian(String userName); // get the librarian credentials
  
  public String addReturnRequest(Borrow borrow);//adding the particular student request
  
  public String deleteReturnRequest(String sid, Integer bid);//deleting the particular student request
  
  public List<Borrow> selectReturnRequest();//Selecting all return requests
  
}
