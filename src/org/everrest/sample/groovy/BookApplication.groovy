package org.everrest.sample.groovy


import javax.ws.rs.core.Application

class BookApplication extends javax.ws.rs.core.Application
{
   Set<Class<?>> getClasses()
   {
      new HashSet<Class<?>>()
   }

   Set<Object> getSingletons()
   {  	   
	   
      new HashSet<Object>([new BookService(bookStorage:new JDOBookStorage()), new BookNotFoundExceptionMapper()])
   }
}