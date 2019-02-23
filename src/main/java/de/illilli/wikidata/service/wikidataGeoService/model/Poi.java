package de.illilli.wikidata.service.wikidataGeoService.model;

public class Poi {

	private String instanceOf;
	private double distance;
	private String placeLabel;
	private String place;
	private String instanceOfLabel;
	private double lat;
	private double lng;
	private String image;

	public String getInstanceOf() {
		return instanceOf;
	}

	public void setInstanceOf(String instanceOf) {
		this.instanceOf = instanceOf;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getPlaceLabel() {
		return placeLabel;
	}

	public void setPlaceLabel(String placeLabel) {
		this.placeLabel = placeLabel;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getInstanceOfLabel() {
		return instanceOfLabel;
	}

	public void setInstanceOfLabel(String instanceOfLabel) {
		this.instanceOfLabel = instanceOfLabel;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((instanceOf == null) ? 0 : instanceOf.hashCode());
		result = prime * result + ((instanceOfLabel == null) ? 0 : instanceOfLabel.hashCode());
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((placeLabel == null) ? 0 : placeLabel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poi other = (Poi) obj;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (instanceOf == null) {
			if (other.instanceOf != null)
				return false;
		} else if (!instanceOf.equals(other.instanceOf))
			return false;
		if (instanceOfLabel == null) {
			if (other.instanceOfLabel != null)
				return false;
		} else if (!instanceOfLabel.equals(other.instanceOfLabel))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (placeLabel == null) {
			if (other.placeLabel != null)
				return false;
		} else if (!placeLabel.equals(other.placeLabel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Poi [instanceOf=" + instanceOf + ", distance=" + distance + ", placeLabel=" + placeLabel + ", place="
				+ place + ", instanceOfLabel=" + instanceOfLabel + ", lat=" + lat + ", lng=" + lng + ", image=" + image
				+ "]";
	}

}
