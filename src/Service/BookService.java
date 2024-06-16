package Service;

import DAO.DAO;
import Entity.Author;
import Entity.Book;
import DAO.GenericDAO;

public class BookService {
    /* Attributes */
    private DAO<Book> bookDao = new GenericDAO<>();
    private DAO<Author> authDao = new GenericDAO<>();

    /* */

}
