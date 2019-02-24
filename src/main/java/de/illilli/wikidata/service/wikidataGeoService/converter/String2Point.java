package de.illilli.wikidata.service.wikidataGeoService.converter;

import java.util.StringTokenizer;

import de.illilli.opendata.service.Converter;
import de.illilli.wikidata.service.wikidataGeoService.model.Point;

public class String2Point extends Point implements Converter<Point, String> {

	@Override
	public Point getAsObject(String value) {
		Point point = new Point();
		StringTokenizer st = new StringTokenizer(value, ",");
		point.setLat(Double.parseDouble(st.nextToken()));
		point.setLng(Double.parseDouble(st.nextToken()));
		return point;
	}

}
