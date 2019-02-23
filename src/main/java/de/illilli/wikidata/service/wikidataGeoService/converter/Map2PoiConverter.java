package de.illilli.wikidata.service.wikidataGeoService.converter;

import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import de.illilli.opendata.service.Converter;
import de.illilli.wikidata.service.wikidataGeoService.model.Poi;

public class Map2PoiConverter implements Converter<Poi, Map<String, String>> {

	@Override
	public Poi getAsObject(Map<String, String> map) {

		Poi poi = new Poi();

		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();

			if ("instanceOf".equals(key)) {
				poi.setInstanceOf(map.get(key));
			}
			if ("distance".equals(key)) {
				String value = map.get(key).substring(0, map.get(key).indexOf("^^"));
				double distance = Double.parseDouble(value);
				poi.setDistance(distance);
			}
			if ("placeLabel".equals(key)) {
				if (map.get(key).indexOf('@') > 0) {
					poi.setPlaceLabel(map.get(key).substring(0, map.get(key).indexOf('@')));
				} else {
					poi.setPlaceLabel(map.get(key));
				}
			}
			if ("place".equals(key)) {
				poi.setPlace(map.get(key));
			}
			if ("instanceOfLabel".equals(key)) {
				if (map.get(key).indexOf('@') > 0) {
					poi.setInstanceOfLabel(map.get(key).substring(0, map.get(key).indexOf('@')));
				} else {
					poi.setInstanceOfLabel(map.get(key));
				}
			}
			if ("location".equals(key)) {
				String value = map.get(key);
				StringBuilder sb = new StringBuilder(value);
				value = sb.substring(value.indexOf('(') + 1, value.indexOf(')'));
				StringTokenizer st = new StringTokenizer(value, " ");
				poi.setLng(Double.parseDouble(st.nextToken()));
				poi.setLat(Double.parseDouble(st.nextToken()));
			}
			if ("image".equals(key)) {
				poi.setImage(map.get(key));
			}
		}

		return poi;
	}

}
