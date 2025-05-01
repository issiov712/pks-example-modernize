package com.test.util;

/**
 * A simple class that has a two strings and an option type value that is used
 * as a key in case you want to sort the list of pairs of strings.
 */
public final class StringSortablePair<K extends Comparable<K>> implements Comparable<StringSortablePair<K>> {

	// allow the same class / package to direcly access
	final K      _key;
	final String _label;
	final String _value;

	public StringSortablePair(final K key, final String label, final String value) {
		this._key   = key;
		this._label = label;
		this._value = value;
	}

	public K key() 		  { return this._key; }
	public String label() { return this._label; }
	public String value() { return this._value; }
	
	@Override
	public int compareTo(StringSortablePair<K> that) {
		
		if (this._key.compareTo(that._key) != 0) {
			return this._key.compareTo(that._key);
		}

		if (this._label.compareTo(that._label) != 0) {
			return this._label.compareTo(that._label);
		}

		if (this._value.compareTo(that._value) != 0) {
			return this._value.compareTo(that._value);
		}

		return 0; // equal
	}
}


