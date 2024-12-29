package com.test;

import com.test.util.StringPair;
import com.test.util.StringSortablePair;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StringPairTest {


	@Test
	public void testStringPairs() {
		List<StringPair> pairs = new ArrayList<StringPair>();
		
		pairs.add(new StringPair("my-label", "my-value"));
		pairs.add(new StringPair("your-label", "your-value"));
		pairs.add(new StringPair("a-label", "a-value"));
		pairs.add(new StringPair("z-label", "z-value"));
		pairs.add(new StringPair("a-label", "z-value"));

		System.out.println("unsorted");
		for ( StringPair sp : pairs ) {
			System.out.println("label: '" + sp.label() + "'\tvalue: '" + sp.value() + "'");
		}

		Collections.sort(pairs);

		System.out.println("sorted");
		for ( StringPair sp : pairs ) {
			System.out.println("label: '" + sp.label() + "'\tvalue: '" + sp.value() + "'");
		}
	}

	@Test
	public void testStringSortablePairsByString() {
		List<StringSortablePair<String>> pairs = new ArrayList<StringSortablePair<String>>();

		pairs.add(new StringSortablePair<String>("my-key","my-label","my-value"));
		pairs.add(new StringSortablePair<String>("a-key","a-label","a-value"));
		pairs.add(new StringSortablePair<String>("z-key","z-label","z-value"));
		pairs.add(new StringSortablePair<String>("b-key","b-label","b-value"));
		pairs.add(new StringSortablePair<String>("y-key","y-label","y-value"));

		System.out.println("unsorted");
		for ( StringSortablePair<String> sp : pairs ) {
			System.out.println("key: '" + sp.key() + "'\tlabel: '" + sp.label() + "'\tvalue: '" + sp.value() + "'");
		}

		Collections.sort(pairs);

		System.out.println("sorted");
		for ( StringSortablePair<String> sp : pairs ) {
			System.out.println("key: '" + sp.key() + "'\tlabel: '" + sp.label() + "'\tvalue: '" + sp.value() + "'");
		}
	}

	@Test
	public void testStringSortablePairsByInteger() {
		List<StringSortablePair<Integer>> pairs = new ArrayList<StringSortablePair<Integer>>();

		pairs.add(new StringSortablePair<Integer>(Integer.valueOf(1),"my-label","my-value"));
		pairs.add(new StringSortablePair<Integer>(Integer.valueOf(3),"a-label","a-value"));
		pairs.add(new StringSortablePair<Integer>(Integer.valueOf(7),"z-label","z-value"));
		pairs.add(new StringSortablePair<Integer>(Integer.valueOf(1),"b-label","b-value"));
		pairs.add(new StringSortablePair<Integer>(Integer.valueOf(3),"y-label","y-value"));

		System.out.println("unsorted");
		for ( StringSortablePair<Integer> sp : pairs ) {
			System.out.println("key: '" + sp.key().toString() + "'\tlabel: '" + sp.label() + "'\tvalue: '" + sp.value() + "'");
		}

		Collections.sort(pairs);

		System.out.println("sorted");
		for ( StringSortablePair<Integer> sp : pairs ) {
			System.out.println("key: '" + sp.key().toString() + "'\tlabel: '" + sp.label() + "'\tvalue: '" + sp.value() + "'");
		}
	}
}
