package de.illilli.wikidata.service.wikidataGeoService;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.Format;

@Path("entity")
public class Entity {

	public static final String ENCODING = Config.getProperty("encoding");

	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	/**
	 * pinging with head request
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@HEAD
	public Response ping() throws JsonProcessingException {
		return Response.status(Status.OK).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{entity}")
	public Response getPoiByEntity(@PathParam("entity") String entity)
			throws IOException, ClassNotFoundException, SQLException, NamingException {

		Facade<String> facade = null;

		String format = request.getParameter("format");
		if (Format.geojson.name().equals(format)) {
			facade = new EntityGeoJsonFacade(entity);
		} else {
			facade = new EntityFacade(entity);
		}

		return Response.status(Status.OK).entity(facade.getData()).build();

	}

}
