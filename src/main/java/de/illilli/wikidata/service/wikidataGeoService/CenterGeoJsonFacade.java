package de.illilli.wikidata.service.wikidataGeoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.geojson.Feature;
import org.geojson.FeatureCollection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.wikidata.service.wikidataGeoService.converter.Poi2Feature;
import de.illilli.wikidata.service.wikidataGeoService.model.Poi;

public class CenterGeoJsonFacade extends CenterFacade {

	private FeatureCollection featureCollection = new FeatureCollection();
	private List<Feature> featureList = new ArrayList<Feature>();

	public CenterGeoJsonFacade(String center) throws IOException {
		// magic is in parent class
		super(center);
		for (Poi poi : super.data) {
			featureList.add(new Poi2Feature().getAsObject(poi));
		}
		featureCollection.addAll(featureList);
	}

	@Override
	public String getData() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

}
