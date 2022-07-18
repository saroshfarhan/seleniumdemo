package com.test.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {


	// Count the number pf names starting with letter A in a list
	// doing this the regular way
	// @Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Ankita");
		names.add("Abhijeet");
		names.add("Alekhya");
		names.add("Don");
		names.add("Swati");
		names.add("Agatha");

		int count = 0;

		for (String name : names) {
			if (name.startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);

	}

	// doing this with the help of JAVA Streams
	// @Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Ankita");
		names.add("Abhijeet");
		names.add("Alekhya");
		names.add("Don");
		names.add("Swati");
		names.add("Agatha");

		// using streams we:
		// First: convert to stream
		// Second: do and intermediate operation here we are using filter(), inside
		// filter we are writing
		// lambda expression to filter out first chracter as "A"
		// Third: do a terminal operation here we are doing the count()
		Long c = names.stream().filter(name -> name.startsWith("A")).count();
		System.out.println(c);
	}

	//@Test
	public void streamMap() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("man");
		names.add("don");
		names.add("women");
		
		
		Stream.of("Abhijeet", "Alekhya", "Agatha", "Rama", "Don").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		
		List<String> names1 = Arrays.asList("Azbhijeet", "Don", "Alekhya", "Adam", "Rama");
		names1.stream().filter(s-> s.startsWith("A")).sorted().map(s-> s.toUpperCase()).forEach(s->System.out.println(s));
		
		//merging two different lists
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		boolean flag = newStream.anyMatch(s-> s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect() {
		
		List<String> ls = Stream.of("Abhijeet", "Alekhya", "Agatha", "Rama", "Don").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
		.collect(Collectors.toList());
		
		System.out.println(ls.get(0));
	}
}
