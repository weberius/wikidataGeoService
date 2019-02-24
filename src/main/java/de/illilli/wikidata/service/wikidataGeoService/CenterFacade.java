package de.illilli.wikidata.service.wikidataGeoService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;
import de.illilli.wikidata.service.wikidataGeoService.converter.Map2PoiConverter;
import de.illilli.wikidata.service.wikidataGeoService.converter.String2Point;
import de.illilli.wikidata.service.wikidataGeoService.model.Poi;
import de.illilli.wikidata.service.wikidataGeoService.model.Point;

public class CenterFacade implements Facade<String> {

	static final String queryFileName = "/query/selectByCenter.sparql";
	static final String sparqlEndpoint = Config.getProperty("sparql.endpoint");

	List<Poi> data = new ArrayList<>();

	public CenterFacade(String center) throws IOException {

		Point point = new String2Point().getAsObject(center);

		InputStream inputStream = EntityFacade.class.getResourceAsStream(queryFileName);
		String queryString = IOUtils.toString(inputStream);

		ParameterizedSparqlString queryStr = new ParameterizedSparqlString(queryString);
		Query query = QueryFactory.create(queryStr.toString());

		QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlEndpoint, query);

		try {

			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				QuerySolution solution = results.next();
				Iterator<String> iterator = solution.varNames();
				Map<String, String> map = new Hashtable<>();

				while (iterator.hasNext()) {
					String key = iterator.next();
					RDFNode value = solution.get(key);
					map.put(key, value.toString());
				}

				data.add(new Map2PoiConverter().getAsObject(map));

			}

			// ResultSetFormatter.out(System.out, results, query);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			qexec.close();
		}
	}

	@Override
	public String getData() throws JsonProcessingException {
		return new Gson().toJson(data);
	}

}
