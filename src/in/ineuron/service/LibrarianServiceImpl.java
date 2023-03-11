package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.ILibrarianDao;
import in.ineuron.dao.LibrarianDaoImpl;
import in.ineuron.dto.Borrow;
import in.ineuron.dto.Librarian;

public class LibrarianServiceImpl implements ILibrarianService {
	ILibrarianDao dao=new LibrarianDaoImpl();

	@Override
	public Librarian getLibrarian(String userName) {
		
		return dao.getLibrarian(userName);
	}

	@Override
	public String addReturnRequest(Borrow borrow) {
		
		return dao.addReturnRequest(borrow);
	}

	@Override
	public String deleteReturnRequest(String sid, Integer bid) {

		return dao.deleteReturnRequest(sid, bid);
	}

	@Override
	public List<Borrow> selectReturnRequest() {
		return dao.selectReturnRequest();
	}

}
