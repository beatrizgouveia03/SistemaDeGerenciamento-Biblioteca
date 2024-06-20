package Service;

import DAO.DAO;
import Entity.Book;
import DAO.GenericDAO;
import Exception.DAOException;

public class BookService {
    /* Attributes */
    private DAO<Book> bookDao = new GenericDAO<>();

    /* Methods */
    public void createBook(Book book) {
        try{
            bookDao.save(book);
        } catch (DAOException e){
            System.out.println("Error creating book: " + e.getMessage());
        }
    }

    public void removeBook(int id){
        try{
            bookDao.delete(id);
        } catch (DAOException e){
            System.out.println("Error removing book: " + e.getMessage());
        }
    }

    public void listAllBooks(){
        try{
            for (Book book : bookDao.findAll()){
                System.out.println(book.toString());
            }
        } catch (DAOException e){
            System.out.println("Error listing books: " + e.getMessage());
        }
    }

    public void listBooksByAuthor(String author){
        try{
            for (Book book : bookDao.findAll((b -> b.getAuthor().equals(author)))){
                System.out.println(book.toString());
            }
        } catch (DAOException e){
            System.out.println("Error listing books by author: " + e.getMessage());
        }
    }

    public void listBooksByGenre(String genre){
        try{
            for (Book book : bookDao.findAll((b -> b.getGenre().equals(genre)))){
                System.out.println(book.toString());
            }
        } catch (DAOException e){
            System.out.println("Error listing books by genre: " + e.getMessage());
        }
    }

}
