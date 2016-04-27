package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Driver;

import hibernate.Books;
import hibernate.Contacts;
import hibernate.Movies;
import hibernate.Music;

//DAO = data access object. This class is the interface between the code and the database.
public class HibernateDataDAO {
	private SessionFactory sessionFactory;
	private Transaction transaction;
	private Connection conn = null;
		
	public void insertBooks(Books books) {
		Session session = sessionFactory.openSession();
		
		try {
			transaction = session.beginTransaction();
			
			session.save(books);
			
			transaction.commit();
		} 
		catch (Exception e) {
		     if (transaction != null) transaction.rollback();
		     throw e;
		}
		finally {
		     session.close();
		}
	}
	
	public void deleteBooks(int booksKey){
		createDatabaseConnection();
		Statement stmt = null;
		String sqlQuery = "DELETE FROM books " +
					 "WHERE booksKey =" + booksKey;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlQuery);
			System.out.println("Deleted book key: " + booksKey);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
	}
	
	public void addBook(String title, String author){
		createDatabaseConnection();
		Statement stmt = null;
		String sqlQuery = "INSERT INTO books(title, author) values('" + title + "','" + author + "')";
	try{
		stmt = conn.createStatement();
		stmt.execute(sqlQuery);
		System.out.println("Added book: " + title + "  " + author);
	} catch (SQLException e){
		e.printStackTrace();
	}
	
	}
	
	private void createDatabaseConnection(){
		try {
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			String URL = "jdbc:mysql://localhost:3306/databaseproject";
			String USER = "root";
			String PASS = "Someone1";
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public ModelAndView getBooks(ModelAndView modelandview){
		Session session = sessionFactory.openSession();
		List<Books> books = null;
		
		try{
			transaction = session.beginTransaction();		

		    Query query = session.createQuery("select books from Books as books");

			books = (List<Books>) query.list();
			modelandview.addObject("books", books);
			System.out.println("Title\tAuthor\t#");
				
			for(Books book: books) {
				System.out.println(book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getBooksKey());
		    }
				
			transaction.commit();
		}catch(HibernateException e){
			if(transaction!= null) transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return modelandview;
	}
	
	public void insertMusic(Music music) {
		Session session = sessionFactory.openSession();
		
		try {
			transaction = session.beginTransaction();
			
			session.save(music);
			
			transaction.commit();
		} 
		catch (Exception e) {
		     if (transaction != null) transaction.rollback();
		     throw e;
		}
		finally {
		     session.close();
		}
	}
	
	
	public void deleteMusic(int musicKey){
		createDatabaseConnection();
		Statement stmt = null;
		String sqlQuery = "DELETE FROM music " + "WHERE musicKey =" + musicKey;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlQuery);
			System.out.println("Deleted music key: " + musicKey);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	
	}
	
	public void addMusic(String title, String artist){
		createDatabaseConnection();
		Statement stmt = null;
		String sqlQuery = "INSERT INTO music(title, artist) values('" + title + "','" + artist + "')";
	try{
		stmt = conn.createStatement();
		stmt.execute(sqlQuery);
		System.out.println("Added music: " + title + "  " + artist);
	} catch (SQLException e){
		e.printStackTrace();
	}
	
	}
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView getMusic(ModelAndView modelandview){
		Session session = sessionFactory.openSession();
		List<Music> music = null;
		
		try{
			transaction = session.beginTransaction();		

		    Query query = session.createQuery("select music from Music as music");

			music = (List<Music>) query.list();
			modelandview.addObject("music", music);
			System.out.println("Title\tArtist\t#");
				
			for(Music musics: music) {
				System.out.println(musics.getTitle() + "\t" + musics.getArtist() + "\t" + musics.getMusicKey());
		    }
				
			transaction.commit();
		}catch(HibernateException e){
			if(transaction!= null) transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return modelandview;
	}
	
	
	public void insertMovies(Movies movies) {
		Session session = sessionFactory.openSession();
		
		try {
			transaction = session.beginTransaction();
			
			session.save(movies);
			
			transaction.commit();
		} 
		catch (Exception e) {
		     if (transaction != null) transaction.rollback();
		     throw e;
		}
		finally {
		     session.close();
		}
	}
	
	public void deleteMovies(int movieKey){
		createDatabaseConnection();
		Statement stmt = null;
		String sqlQuery = "DELETE FROM movies " + "WHERE movieKey =" + movieKey;
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlQuery);
			System.out.println("Deleted movie key :" + movieKey);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void addMovie(String title, String rating){
		createDatabaseConnection();
		Statement stmt = null;
		String sqlQuery = "INSERT INTO movies(title, rating) values('" + title + "','" + rating + "')";
	try{
		stmt = conn.createStatement();
		stmt.execute(sqlQuery);
		System.out.println("Added movie: " + title + "  " + rating);
	} catch (SQLException e){
		e.printStackTrace();
	}
	
	}
	
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView getMovies(ModelAndView modelandview){
		Session session = sessionFactory.openSession();
		List<Movies> movies = null;
		
		try{
			transaction = session.beginTransaction();		

		    Query query = session.createQuery("select movies from Movies as movies");

			movies = (List<Movies>) query.list();
			modelandview.addObject("movies", movies);
			System.out.println("Title\tRating\t#");
				
			for(Movies movie: movies) {
				System.out.println(movie.getTitle() + "\t" + movie.getRating() + "\t" + movie.getMovieKey());
		    }
				
			transaction.commit();
		}catch(HibernateException e){
			if(transaction!= null) transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return modelandview;
	}
	
	public void insertContacts(Contacts contacts) {
		Session session = sessionFactory.openSession();
		
		try {
			transaction = session.beginTransaction();
			
			session.save(contacts);
			
			transaction.commit();
		} 
		catch (Exception e) {
		     if (transaction != null) transaction.rollback();
		     throw e;
		}
		finally {
		     session.close();
		}
	}
	
	public void deleteContacts(int contactKey){
		createDatabaseConnection();
		Statement stmt = null;
		String sqlQuery = "DELETE FROM contacts " +
					 "WHERE contactKey =" + contactKey;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlQuery);
			System.out.println("Deleted contact key: " + contactKey);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
	}
	
	public void addContacts(String name, String email){
		createDatabaseConnection();
		Statement stmt = null;
		String sqlQuery = "INSERT INTO contacts(name, email) values('" + name + "','" + email + "')";
	try{
		stmt = conn.createStatement();
		stmt.execute(sqlQuery);
		System.out.println("Added contact: " + name + "  " + email);
	} catch (SQLException e){
		e.printStackTrace();
	}
	
	}
	
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView getContacts(ModelAndView modelandview){
		Session session = sessionFactory.openSession();
		List<Contacts> contacts = null;
		
		try{
			transaction = session.beginTransaction();		

		    Query query = session.createQuery("select contacts from Contacts as contacts");

			contacts = (List<Contacts>) query.list();
			modelandview.addObject("contacts", contacts);
			System.out.println("Name\tEmail\t#");
				
			for(Contacts contact: contacts) {
				System.out.println(contact.getName() + "\t" + contact.getEmail() + "\t" + contact.getContactKey());
		    }
				
			transaction.commit();
			
		}catch(HibernateException e){
			if(transaction!= null) transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return modelandview;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private void createSessionToDatabase(){
		
	}
}