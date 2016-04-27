package controllers;

import org.springframework.web.servlet.ModelAndView;

import dao.HibernateDataDAO;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.EntertainmentModel;

@Controller
public class EntertainmentController {
	private ModelAndView bookModel;
	private ModelAndView movieModel;
	private ModelAndView musicModel;
	private ModelAndView contactsModel;
	private EntertainmentModel model;
	
	@RequestMapping(value = "/books" , method= RequestMethod.POST)
	public ModelAndView getBookModel() {
		bookModel = model.books(bookModel);
		return bookModel;
	}

	public void setBookModel(ModelAndView bookModel) {
		this.bookModel = bookModel;
	}
	@RequestMapping(value="/deleteBook/{booksKey}", method= RequestMethod.POST)
	public void deleteBook(@PathVariable String booksKey, HttpServletRequest request){
		System.out.println("BOOK KEY TO DELETE:" + booksKey);
		HibernateDataDAO dao = new HibernateDataDAO();
		int intBooksKey = Integer.parseInt(booksKey);
		dao.deleteBooks(intBooksKey);
		
	}
	@RequestMapping(value="/addBook/{title}/{author}", method = RequestMethod.POST)
	public ResponseEntity<Object> addBook(@PathVariable String title, @PathVariable String author, HttpServletRequest request){
		System.out.println("BOOK TO ADD:" + title + "  " + author);
		HibernateDataDAO dao = new HibernateDataDAO();
		dao.addBook(title, author);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/movies", method = RequestMethod.POST)
	public ModelAndView getMovieModel() {
		movieModel = model.movies(movieModel);
		return movieModel;
	}

	public void setMovieModel(ModelAndView movieModel) {
		this.movieModel = movieModel;
	}

	@RequestMapping(value="/deleteMovie/{movieKey}", method = RequestMethod.POST)
	public void deleteMovie(@PathVariable String movieKey, HttpServletRequest request){
		System.out.print("MOVIE KEY TO DELETE:" + movieKey);
		HibernateDataDAO dao = new HibernateDataDAO();
		int intMovieKey = Integer.parseInt(movieKey);
		dao.deleteMovies(intMovieKey);
	}
	
	@RequestMapping(value="/addMovie/{title}/{rating}", method = RequestMethod.POST)
	public ResponseEntity<Object> addMovie(@PathVariable String title, @PathVariable String rating, HttpServletRequest request){
		System.out.println("MOVIE TO ADD:" + title + "  " + rating);
		HibernateDataDAO dao = new HibernateDataDAO();
		dao.addMovie(title, rating);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/music", method = RequestMethod.POST)
	public ModelAndView getMusicModel() {
		musicModel = model.music(musicModel);
		return musicModel;
	}
	
	public void setMusicModel(ModelAndView musicModel) {
		this.musicModel = musicModel;
	}
	
	@RequestMapping(value="/deleteMusic/{musicKey}", method = RequestMethod.POST)
	public void deleteMusic(@PathVariable String musicKey, HttpServletRequest request){
		System.out.print("MUSIC KEY TO DELETE:" + musicKey);
		HibernateDataDAO dao = new HibernateDataDAO();
		int intMusicKey = Integer.parseInt(musicKey);
		dao.deleteMusic(intMusicKey);
	}
	
	@RequestMapping(value="/addMusic/{title}/{artist}", method = RequestMethod.POST)
	public ResponseEntity<Object> addMusic(@PathVariable String title, @PathVariable String artist, HttpServletRequest request){
		System.out.println("MUSIC TO ADD:" + title + "  " + artist);
		HibernateDataDAO dao = new HibernateDataDAO();
		dao.addMusic(title, artist);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public ModelAndView getContactsModel() {
		contactsModel = model.contacts(contactsModel);
		return contactsModel;
	}
	
	public void setContactsModel(ModelAndView contactsModel) {
		this.contactsModel = contactsModel;
	}
	
	@RequestMapping(value="/deleteContact/{contactKey}", method = RequestMethod.POST)
	public void deleteContact(@PathVariable String contactKey, HttpServletRequest request){
		System.out.print("CONTACT KEY TO DELETE:" + contactKey);
		HibernateDataDAO dao = new HibernateDataDAO();
		int intContactKey = Integer.parseInt(contactKey);
		dao.deleteContacts(intContactKey);
	}
	
	@RequestMapping(value="/addContact/{name}/{email}", method = RequestMethod.POST)
	public ResponseEntity<Object> addContact(@PathVariable String name, @PathVariable String email, HttpServletRequest request){
		System.out.println("CONTACT TO ADD:" + name + "  " + email);
		HibernateDataDAO dao = new HibernateDataDAO();
		dao.addContacts(name, email);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public EntertainmentModel getModel() {
		return model;
	}

	public void setModel(EntertainmentModel model) {
		this.model = model;
	}

}