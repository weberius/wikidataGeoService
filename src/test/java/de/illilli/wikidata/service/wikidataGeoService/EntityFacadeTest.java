package de.illilli.wikidata.service.wikidataGeoService;

import java.io.IOException;

import org.junit.Test;

import de.illilli.opendata.service.Facade;

public class EntityFacadeTest {

	@Test
	public void test() throws IOException {
		String entity = "Q3012";
		Facade<String> facade = new EntityFacade(entity);
		String data = facade.getData();
		System.out.println(data);
	}

}
