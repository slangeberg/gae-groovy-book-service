package org.everrest.sample.groovy

import java.util.concurrent.ConcurrentHashMap
import java.util.logging.Logger

import javax.jdo.PersistenceManager
import javax.jdo.Query

import org.everrest.sample.groovy.data.PMF

class JDOBookStorage {
	private static final Logger log = Logger.getLogger(JDOBookStorage.class.getName());

	PersistenceManager pm = PMF.get().getPersistenceManager();

	JDOBookStorage()
	{
		init()
	}

	private void init()
	{
		def num = numberOfBooks()
		
		log.info( "init() numBooks: " + num )
		
		if( num == 0 ) {
			postBook(new Book(title:'JUnit in Action', author:'Vincent Massol', pages:386, price:19.37))
		}
	}

	Book getBook(Long id)
	{
		log.info( "getBook( ${id}" )
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Book result
		try {

	// Note: This query works fine, but is verbose for fetching record by id
			
//			Query query = pm.newQuery( Book.class ); 
//			query.setFilter("id == ${id}" );
//			List<Book> books = (List<Book>)query.execute();
//			if ( books.size() == 0 )
//				throw new BookNotFoundException(id)
//			
//			result = books.get(0)
			
			result = pm.getObjectById( Book.class, id )
			
			log.info( "result: " + result )
			
			if ( !result )
				throw new BookNotFoundException(id)
			
		} finally {
			pm.close();
		}
		result
	}


	String postBook(Book book)
	{
		log.info( "postBook: " + book )

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Book b
		try {
			b = pm.makePersistent( book );
		} finally {
			pm.close();
		}
		
		log.info "postBook - result: ${b}"

		b.id.toString()
	}

	Collection<Book> getAll()
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Book> results
		try {
			Query query = pm.newQuery(Book.class);
			results = (List<Book>)query.execute();
			results.size() // bug: must force fetch, else you get nyet
		} finally {
			pm.close();
		}
		results
	}

	int numberOfBooks()
	{
		List<Book> results = getAll()
		def len = results != null ? results.size() : 0
		len
	}
}