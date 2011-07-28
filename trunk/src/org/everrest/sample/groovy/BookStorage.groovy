package org.everrest.sample.groovy

import java.util.logging.Logger
import java.util.concurrent.ConcurrentHashMap

class BookStorage
{
	private static final Logger log = Logger.getLogger(BookStorage.class.getName());
   
	private static int idCounter = 100
   
   synchronized String generateId()
   {
      idCounter++
      Integer.toString(idCounter)
   }
   
   private Map books = new ConcurrentHashMap()
   
   BookStorage()
   {
      init()
   }
   
   private void init()
   {
      postBook(new Book(title:'JUnit in Action', author:'Vincent Massol', pages:386, price:19.37))
   }
   
   Book getBook(String id)
   {
      books[id]
   }
   
//   String putBook(Book book)
//   {
//	  String id = book.getId()
//	  if (id == null || id.trim().length() == 0)
//	  {
//		 id = generateId()
//		 book.setId(id)
//	  }
//	  books[id] = book
//	  id
//   }
   
   String postBook(Book book)
   {
	   log.info( "postBook: " + book )
	   
      String id = book.id
      if (id == null || id.trim().length() == 0)
      {
         id = generateId()
         book.id = id
      }
      books[id] = book
      id
   }
   
   Collection<Book> getAll()
   {
      books.values()
   }
   
   int numberOfBooks()
   {
      books.size()
   }
}