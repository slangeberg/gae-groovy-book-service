package org.everrest.sample.groovy

class BookNotFoundException extends Exception
{
   BookNotFoundException(Long id)
   {
      super("Book with id '${id}' not found.".toString());
   }
}
