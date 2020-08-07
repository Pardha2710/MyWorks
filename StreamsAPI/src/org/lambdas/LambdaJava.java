package org.lambdas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaJava{  
	public static void main(String[] args) throws IOException {  
		
		
		System.out.println("This contains examples of Java 8 Lambdas and Streams API...");
    
		//1.Integer Stream with range() & forEach
		IntStream.range(1, 10).
			forEach(System.out::print);	//	o/p: 1 to 9 Numbers
		System.out.println();
		
		//2.Integer Stream with skip() & forEach with Lambda
		IntStream.range(1, 10).
			skip(5).
				forEach(x->System.out.print(x)); 	//	o/p: 6 to 9 Numbers
		System.out.println();
		
		
		//3.Integer Stream with sum()
		System.out.println(
					IntStream.range(1, 5).
						sum()); //o/p: (1+2+3+4=10)
		System.out.println();
		
		//4.Stream.of with sorted() , findFirst() & ifPresent()
		Stream.
			of("Avinash","Anil","Ali-Reza").
				sorted().
					findFirst().
						ifPresent(System.out::println); //o/p: Ali-Reza
		System.out.println();
		
		
		//5.Stream from Array of Strings with filter() using Lambda , sorted() & forEach()
		String[]  persons= {"Ali","Krishna","Ram","Raj","Suneel","Jay","Cheery","Suri"};
		Arrays.stream(persons). //Similar to Streams.of(persons)
			filter(x->x.startsWith("R")).
				sorted().
					forEach(System.out::println); //o/p: [Raj,Ram]
		System.out.println();
		
		//6.Average of squares of Int array using map() , average() & ifPresent()
		Arrays.stream(new int[] {2,4,6,8,10}).
			map(x->x*x). //Map Each item to its Square using Lambda
				average().
					ifPresent(System.out::println); //o/p: 44.0
		System.out.println();
		
		
		//7.Stream from List using map(), filter() using Lambda & forEach()
		List<String> names = Arrays.asList("Ali","Krishna","Ram","Raj","Suneel","Jay","Cheery","Suri");
		names.
			stream().
				map(String::toLowerCase). // Map each item to Lower Case
					filter(x->x.startsWith("a")). //Filtering Items using Lambda 
						forEach(System.out::println); //Terminal Operation
		System.out.println();
		
		
		//8.Stream from text File using sorted(),filter() using Lambda & forEach()
		Stream<String> teams=Files.lines(Paths.get("C:/Users/Owner/Desktop/nbateams.txt"));
		teams.
			sorted().
				filter(x->x.length()>13).
					forEach(System.out::println);//o/p: List of Team Names with Lenght > 13
		teams.close();
		System.out.println();
		
		
		//9.List from text File using filter() using Lambda , collect(),forEach()
		List<String> teamsN=Files.lines(Paths.get("C:/Users/Owner/Desktop/nbateams.txt")).
				filter(x->x.contains("rs")).
					collect(Collectors.toList());
		teamsN.forEach(x->System.out.println(x));
		System.out.println();
		
		//10.Stream rows from csv file and the count using map() , filter() with Lambda & count()
		Stream<String> rowss=Files.lines(Paths.get("C:/Users/Owner/Desktop/sample.txt"));
		int count=(int) rowss.
				map(x->x.split(",")).
					filter(x->x.length==3).
						count();
		System.out.println("There are "+count+" rows");
		rowss.close();
		System.out.println();
		
		//11.Stream rows from csv file and the count using map() , filter() with Lambda & count()
		Stream<String> rows=Files.lines(Paths.get("C:/Users/Owner/Desktop/sample.txt"));
		rows.
			map(x->x.split(",")).
				filter(x->x.length==3).
					filter(x->x[1].length()==6).
						forEach(x->System.out.println(x[1]));
		rows.close();
		System.out.println();
		
		
		//12.Stream rows from csv file , store field values in HashMap
		Stream<String> rowws=Files.lines(Paths.get("C:/Users/Owner/Desktop/sample1.txt"));
		Map<String, Integer> map=new HashMap<>();
		map=rowws.
				map(x->x.split(",")).
					filter(x->x.length==3).
						filter(x->Integer.parseInt(x[1]) > 15).
							collect(Collectors.toMap(x->x[0], x->Integer.parseInt(x[1])));
		rowws.close();
		for(String key:map.keySet())
		{
			System.out.println(key + "  " + map.get(key));
		}
		System.out.println();
		
		//13.reduce() with sum
		double finalSum=Stream.of(2.4,1.9,7.5).
				reduce(0.0, (Double a,Double b)->a+b);
		System.out.println("Sum of Numbers is:"+finalSum);
		System.out.println();
		
		
		//14.summaryStatistics() with IntSummaryStatistics
		IntSummaryStatistics summary=IntStream.of(5,9,10,86,92).
				summaryStatistics();
		System.out.println(summary);
		System.out.println( 
			      String.format("%.2f", summary.getAverage())); 
		System.out.println();
		
				
	}
	
}