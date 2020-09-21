package JSON_Streams.JSON_Streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class BooksJSON {

	public static void main(String[] args) {
		 HashMap<Integer,Book> bookMap = new HashMap<Integer,Book>();
		 Book book1=new Book(101, "C-Programming", "Ritchie", "Pearson", 23);
		 Book book2=new Book(101, "Java-Programming", "James", "Pearson", 23);
		 Book book3=new Book(101, ".NET-Programming", "Robert", "Pearson", 23);
		 bookMap.put(book1.id, book1);
		 bookMap.put(book2.id, book2);
		 bookMap.put(book3.id, book3);
		 
		 JSONObject jsonBook1=new JSONObject();
		 jsonBook1.put("id", book1.id);
		 jsonBook1.put("name", book1.name);
		 jsonBook1.put("author", book1.author);
		 jsonBook1.put("publisher", book1.publisher);
		 jsonBook1.put("quantity", book1.quantity);
		 
	      JSONObject bookObject1= new JSONObject(); 
	      bookObject1.put("book1", jsonBook1);
	      
	      
	      JSONObject jsonBook2=new JSONObject();
			 jsonBook2.put("id", book2.id);
			 jsonBook2.put("name", book2.name);
			 jsonBook2.put("author", book2.author);
			 jsonBook2.put("publisher", book2.publisher);
			 jsonBook2.put("quantity", book2.quantity);
			 
		      JSONObject bookObject2 = new JSONObject(); 
		      bookObject2.put("book2", jsonBook2);
		      
		      
		      JSONObject jsonBook3=new JSONObject();
				 jsonBook3.put("id", book3.id);
				 jsonBook3.put("name", book3.name);
				 jsonBook3.put("author", book3.author);
				 jsonBook3.put("publisher", book3.publisher);
				 jsonBook3.put("quantity", book3.quantity);
				 
			      JSONObject bookObject3 = new JSONObject(); 
			      bookObject3.put("book3", jsonBook3);
			      
			      JSONArray booksList = new JSONArray();
			      booksList.add(bookObject1);
			      booksList.add(bookObject2);
			      booksList.add(bookObject3);
			      
			      
			    //Write JSON file
			        try (FileWriter file = new FileWriter("books.json")) {
			 
			            file.write(booksList.toJSONString());
			            file.flush();
			 
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
	      
			        //JSON parser object to parse read file
			        JSONParser jsonParser = new JSONParser();
			         
			        try (FileReader reader = new FileReader("books.json"))
			        {
			            //Read JSON file
			            Object obj = jsonParser.parse(reader);
			 
			            JSONArray booksList1 = (JSONArray) obj;
			            System.out.println(booksList);
			             
			            
			 
			        } catch (FileNotFoundException e) {
			            e.printStackTrace();
			        } catch (IOException e) {
			            e.printStackTrace();
			        } catch (ParseException e) {
			            e.printStackTrace();
			        }
			        	
		 

	}
	private static void parseBookObject(JSONObject book) 
    {
        //Get book object within list
        JSONObject bookObject = (JSONObject) book.get("book");
        
        int id=(int) bookObject.get("id");
        System.out.println(id);
        
        String name = (String) bookObject.get("name");    
        System.out.println(name);
         
        String author = (String) bookObject.get("author");    
        System.out.println(author);
        
        String publisher = (String) bookObject.get("publisher");    
        System.out.println(publisher);
        
        int quantity=(int) bookObject.get("quantity");
        System.out.println(quantity);
        
    }

}
