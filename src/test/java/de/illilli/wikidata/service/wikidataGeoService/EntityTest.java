package de.illilli.wikidata.service.wikidataGeoService;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class EntityTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(Entity.class);
	}

	@Test
	public void testPing() {
		final int status = target().path("entity").request().head().getStatus();
		assertEquals(Response.Status.OK.getStatusCode(), status);
	}

}
