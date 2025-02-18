package composicaoModelagem2;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comment comment1 = new Comment("Have a nice Trip");
		Comment comment2 = new Comment("Wow, That's awesome");
		Comment comment3 = new Comment("Good night");
		Comment comment4 = new Comment("May the Force be with you");
		
		Post post1 = new Post(sdf.parse("21/06/2018 13:05:44"), 
				"Travelling to New Zeland", 
				"I'm going to visit this wonderful country!", 
				12);
		
		post1.addComment(comment1);
		post1.addComment(comment2);
		
		Post post2 = new Post(sdf.parse("28/07/2018 23:14:19"), 
				"Good night guys", 
				"See you tomorrow", 
				5);
		
		post2.addComment(comment3);
		post2.addComment(comment4);
		
		System.out.println(post1.toString());
		System.out.println(post2.toString());	
		
		
	}
}
