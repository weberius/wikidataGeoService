package de.illilli.opendata.service;

/**
 * 
 * Converts an value to Object of type T and an Object of type T to type V.
 *
 * @param <T>
 * @param <U>
 * @param <V>
 */
public interface Converter<T, U> {

	T getAsObject(U value);

}
