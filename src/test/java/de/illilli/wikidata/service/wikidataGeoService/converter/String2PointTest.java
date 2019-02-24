package de.illilli.wikidata.service.wikidataGeoService.converter;

import org.junit.Assert;
import org.junit.Test;

import de.illilli.wikidata.service.wikidataGeoService.model.Point;

public class String2PointTest {

	@Test
	public void testLat() {
		String center = "9.9882203,48.396738";
		Point point = new String2Point().getAsObject(center);
		double delta = 0.0;
		double expected = 9.9882203;
		double actual = point.getLat();
		Assert.assertEquals(expected, actual, delta);
	}

	@Test
	public void testLng() {
		String center = "9.9882203,48.396738";
		Point point = new String2Point().getAsObject(center);
		double delta = 0.0;
		double expected = 48.396738;
		double actual = point.getLng();
		Assert.assertEquals(expected, actual, delta);
	}

}
