package org.everrest.sample.groovy.data


import javax.jdo.JDOHelper
import javax.jdo.PersistenceManagerFactory

final class PMF {
	private static final PersistenceManagerFactory pmfInstance =
		JDOHelper.getPersistenceManagerFactory("transactions-optional");

	private PMF() {}

	static PersistenceManagerFactory get() {
		return pmfInstance;
	}
}