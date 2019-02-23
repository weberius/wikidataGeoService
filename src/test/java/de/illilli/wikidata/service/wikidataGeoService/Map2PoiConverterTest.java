package de.illilli.wikidata.service.wikidataGeoService;

import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;

import de.illilli.wikidata.service.wikidataGeoService.converter.Map2PoiConverter;
import de.illilli.wikidata.service.wikidataGeoService.model.Poi;

public class Map2PoiConverterTest {

	@Test
	public void test() {
		Map<String, String> map = new Hashtable<>();
		map.put("instanceOf", "http://www.wikidata.org/entity/Q515");
		map.put("distance", "0.123^^http://www.w3.org/2001/XMLSchema#double");
		map.put("placeLabel", "Ulm@de");
		map.put("place", "http://www.wikidata.org/entity/Q3012");
		map.put("instanceOfLabel", "Stadt@de");
		map.put("location", "Point(9.99155 48.39841)^^http://www.opengis.net/ont/geosparql#wktLiteral");
		map.put("image", "http://commons.wikimedia.org/wiki/Special:FilePath/Ulm%20vom%20sprollheim%20aus.jpg");

		Poi poi = new Map2PoiConverter().getAsObject(map);

		System.out.println(poi.toString());
	}

}
