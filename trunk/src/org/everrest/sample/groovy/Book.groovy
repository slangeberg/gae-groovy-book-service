package org.everrest.sample.groovy

import javax.jdo.annotations.IdGeneratorStrategy
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable
import javax.jdo.annotations.Persistent
import javax.jdo.annotations.PrimaryKey
import com.google.appengine.api.datastore.Key

@PersistenceCapable(identityType = IdentityType.APPLICATION)
class Book  
{
//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	String id
//	protected void setId(String id) { this.id = id }
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long id;
	protected void setId(Long id) { this.id = id }
	
	@Persistent
	String title
	
	@Persistent
	String author
	
	@Persistent
	int pages
	
	@Persistent
	double price
	//@Persistent
	//String id
	
	@Persistent
	String isbn
}