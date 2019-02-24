# wikidataGeoService

Ziel dieses Projektes ist es auf räumliche Daten in wikidata per Service zuzugreifen. Dabei wird die Abfrage gegen wikidata per Apache Jena gekapselt. Um die Daten ohne weiteres z.B. per leaflet anzeigen zu können, werden die Ergebnisse per GeoJson ausgeliefert.

# Szenarien

Dieser Service kann immer dann genutzt werden, wenn die Umgebung um einen Punkt herum nach Wikidata Punkten untersucht werden soll. Dabei ist es möglich, 

# Entwicklungsstand

Dieses Projekt befindet sich in der Entwicklung

# Daten

Die Applikation basiert auf Daten die in [wikidata](https://www.wikidata.org/wiki/Wikidata:Main_Page) zur Verfügung stehen. 

# Technologien/ Bibliotheken

- wikidata
- Apache Jena
- Jersey
- Gson
- opendatalab geojson
- Apache commoins io

# Schnittstellen

## /wikidataGeoService/entity/{entity}

Mit dieser Schnittstelle wird die Geolocation einer entity ausgewertet, um das Centrum der Abfrage zu bestimmen.

### Wikidata Query 

{entitiy} ist hier die Stadt Ulm (Q3012)

	SELECT ?place ?placeLabel ?image ?coordinate_location ?dist ?instance_of ?instance_ofLabel 
	WHERE {
	  wd:Q3012 wdt:P625 ?loc
	  SERVICE wikibase:around {
	    ?place wdt:P625 ?coordinate_location.
	    bd:serviceParam wikibase:center ?loc .
	    bd:serviceParam wikibase:radius "1".
	    bd:serviceParam wikibase:distance ?dist.
	  }
	  SERVICE wikibase:label { bd:serviceParam wikibase:language "[AUTO_LANGUAGE],en". }
	  OPTIONAL { ?place wdt:P18 ?image. }
	  OPTIONAL { ?place wdt:P31 ?instance_of. }
	}
	ORDER BY ASC(?dist)
	
### Rückgabe

Der Service kann die Informationen sowohl json formattiert, als auch im GeoJson Format zurückgeben. 

## /wikidataGeoService/center/{x,y}&radius={radius}

Der Radius wird in km angegeben; default 1 km 

	SELECT ?place ?placeLabel ?image ?coordinate_location ?dist ?instance_of ?instance_ofLabel 
	WHERE {
	  SERVICE wikibase:around {
	    ?place wdt:P625 ?coordinate_location.
	    bd:serviceParam wikibase:center "Point(9.9882203 48.396738)"^^geo:wktLiteral .
	    bd:serviceParam wikibase:radius "0.1".
	    bd:serviceParam wikibase:distance ?dist.
	  }
	  SERVICE wikibase:label { bd:serviceParam wikibase:language "[AUTO_LANGUAGE],en". }
	  OPTIONAL { ?place wdt:P18 ?image. }
	  OPTIONAL { ?place wdt:P31 ?instance_of. }
	}
	ORDER BY ASC(?dist)

## /wikidataGeoService/bbox/{x,y;x,y}

Wikidata Abfrage basiert auf der Bounding Box

	SELECT ?place ?placeLabel ?image ?location ?instance_of ?instance_ofLabel  
	WHERE {
	SERVICE wikibase:box {
	    ?place wdt:P625 ?location .
	    bd:serviceParam wikibase:cornerWest "Point(9.9815143 48.402069)"^^geo:wktLiteral .
	    bd:serviceParam wikibase:cornerEast "Point(10.0005363 48.395145)"^^geo:wktLiteral .
	  }
	  SERVICE wikibase:label { bd:serviceParam wikibase:language "[AUTO_LANGUAGE],en". }
	  OPTIONAL { ?place wdt:P18 ?image. }
	  OPTIONAL { ?place wdt:P31 ?instance_of. }
	}

# License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.
