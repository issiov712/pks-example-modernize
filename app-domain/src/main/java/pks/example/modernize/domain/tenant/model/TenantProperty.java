package pks.example.modernize.domain.tenant.model;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class TenantProperty extends ImmutablePair<String,String[]> {
	
	TenantProperty(final String label, final String value) {
		super(label,new String[] { value });
	}

	TenantProperty(final String label, final String[] values) {
		super(label,values);
	}

	TenantProperty(final String label, final List<String> values) {
		super(label,values.toArray(new String[0]));
	}

	public String label() { return this.left; }
	public String[] value() { return this.right; }
	public String value(int i) { return this.right == null ? null : ( i < 0 || i >= right.length ) ? null : this.right[i]; }
	public int valueLength() { return this.right == null ? 0 : right.length; }

	public TenantProperty removeValue(int i) {
		if (this.right == null || i < 0 || i >= right.length) {
			return this;
		}

		String[] result = new String[right.length-1];
		System.arraycopy(right, 0, result, 0, i);
		System.arraycopy(right, i + 1, result, i, right.length - i - 1);
		return new TenantProperty(left,result);		
	}

	public TenantProperty appendValue(String value) {
		String[] result = Arrays.copyOf(right, right.length + 1);
		result[right.length] = value;
		return new TenantProperty(left, result);
	}

	public TenantProperty addValue(int i, String value) {
		if (this.right == null || i < 0 || i >= right.length - 1) {
			return this;
		}

		String[] result = Arrays.copyOf(right,right.length + 1);
		System.arraycopy(right, 0, result, 0, i);
		System.arraycopy(right, i + 1, result, i, right.length - i - 1);
		return new TenantProperty(left,result);
	}

	public TenantProperty setValue(final String value) {
		return new TenantProperty(left,value);
	}
}
