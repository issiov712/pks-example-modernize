package pks.example.modernize.util.type;

/**
 * A simple "record" type class to provide a label and value for report headers.
 */
public final class StringPair implements Comparable<StringPair> {

	// allow the same class / package to direcly access
	final String _label;
	final String _value;

	public StringPair(final String label, final String value) {
		this._label = label;
		this._value = value;
	}

	public String label() { return this._label; }
	public String value() { return this._value; }
	
	@Override
	public int compareTo(StringPair that) {
		
		if (this._label.compareTo(that._label) != 0) {
			return this._label.compareTo(that._label);
		}

		if (this._value.compareTo(that._value) != 0) {
			return this._value.compareTo(that._value);
		}

		return 0; // equal
	}
}
