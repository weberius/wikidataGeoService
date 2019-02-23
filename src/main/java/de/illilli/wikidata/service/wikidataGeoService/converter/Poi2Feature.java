package de.illilli.wikidata.service.wikidataGeoService.converter;

import java.util.HashMap;
import java.util.Map;

import org.geojson.Feature;
import org.geojson.Point;

import de.illilli.opendata.service.Converter;
import de.illilli.wikidata.service.wikidataGeoService.model.Poi;

public class Poi2Feature implements Converter<Feature, Poi> {

	@Override
	public Feature getAsObject(Poi poi) {

		Feature feature = new Feature();
		feature.setId(poi.getPlace());

		Map<String, Object> properties = new HashMap<>();
		properties.put("image", poi.getImage());
		properties.put("place", poi.getPlaceLabel());
		properties.put("instanceOf", poi.getInstanceOfLabel());

		feature.setProperties(properties);

		Point point = new Point(poi.getLng(), poi.getLat());
		feature.setGeometry(point);

		return feature;
	}

}
