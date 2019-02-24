package de.illilli.wikidata.service.wikidataGeoService;

import java.io.IOException;

import org.junit.Test;

import de.illilli.opendata.service.Facade;

public class CenterGeoJsonFacadeTest {

	@Test
	public void test() throws IOException {
		String center = "9.9882203,48.396738";
		Facade<String> facade = new CenterGeoJsonFacade(center);
		String data = facade.getData();
		System.out.println(data);
	}

}
