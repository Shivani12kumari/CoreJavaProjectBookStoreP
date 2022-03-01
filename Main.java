import java.util.ArrayList;
	import java.util.Scanner;

public class Main {
		//ArrayList of different book
		public static ArrayList<Book> books;
		
		
		private static Scanner scanner;
		
		
	    public static int id =0;
		public static void main(String[] args) {
			books=new ArrayList<>();
			System.out.println("Welcome to Online Book Store");
			showInitialOptions();
		}
		private static void showInitialOptions()
		{
		 System.out.println("Please Select One"+
		                    "\n\t1.Manage Books"+
				             "\n\t2.Book Description"+
		                    "\n\t3. Exit");
			scanner =new Scanner(System.in);
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				manageBooks();
				break;
			case 2:
				manageMessages();
			case 3:
				showInitialOptions();
				break;
			}
		}

		private static void manageBooks(){
			System.out.println("please select one:"+
		           "\n\t1.Show all Books"+
					"\n\t2.Add a new One"+
		           "\n\t3.Search for a Book"+
					"\n\t4.Go Back");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				showAllBooks();
				break;
			case 2:
				addNewBook();
				break;
			case 3:
				searchForBook();
				break;
			case 4:
				deleteBook();
				break;	
			case 5:
				showInitialOptions();
				break;
			default:
				manageBooks();
				break;
			}
		}

		private static void showAllBooks() {
			System.out.println("Book Name\t\t\tBook Number\t\t\t Book Price");
			System.out.println("*************************************************************");  
			for (Book b:books)
			{
				b.getDetails();
			}
			System.out.println("*************************************************************");
			
			manageBooks();
			 //showInitialOptions();  
		}
		private static void addNewBook() {
			System.out.println("Adding new Book..."+
		                       "\n Please enter book's name");
			String name= scanner.next();
			System.out.println("Please enter book's code");
			String number=scanner.next();
			System.out.println("Please enter book's Price");
			String price= scanner.next();
			
			if (name.equals("")||number.equals("")||price.equals(""))
			{
				System.out.println("Please enter all the information");
				addNewBook();
			}
			else {
				boolean doesExist=false;
				for(Book b:books)
				{
					if(b.getNumber().equals(number)) {
						
						doesExist=true;
					}
					if(doesExist) {
						System.out.println("a book with code"+number+"already exist");
						addNewBook();
					}
					else {
						Book book =new Book(name,null, number,price);
						books.add(book);
						System.out.println(name+"Added Succesfully");
					   }	
				}
				manageBooks();
			}
		}
		
			private static void searchForBook() {
				System.out.println("Please enter Book Name");
				String name= scanner.next();
				if(name.equals(""))
				{
					System.out.println("Please enter book name");
					searchForBook();
				}
				else {
					boolean doesExist=false;
					System.out.println("Book Name\t\t\tBook Number\t\t\t Book Price");
					
					System.out.println("****************************************************");
				    
					      for(Book b:books) {
					    	  if(b.getName().equals(name))
					    	  {
					    		  doesExist=true;
					    		  b.getDetails();
					    	  }
					      }
					      System.out.println("*************");
					      
					      if(!doesExist) {
					    	  System.out.println("There no such in our book store");
					      }
				
				   }
				manageBooks();
			}
				private static void deleteBook() {
				System.out.println("Please Enter Book's name");
				String name=scanner.next();
				if(name.equals(""))
				{
					System.out.println("please enter book's Name");
					deleteBook();
				}
				else {
					boolean doesExist=false;
					for(Book b:books) {
						if(b.getName().equals(name))
						{
							//change value of doesExist variable
							doesExist=true;
							//remove contact from book array list
							books.remove(b);
							System.out.println(name+"Book Deleted Succesfully");
							showAllBooks();
							manageBooks();
							
						}
						
					}
					if(!doesExist) {
						System.out.println("There is no such Book in our store ");
					}
				}
				showInitialOptions();
				}
			
		

		private static void manageMessages() {
			System.out.println("Please select one:"
					+"\n\t1.show all description"
					+"\n\t2.Add New Description"
					+"\n\t3.Go Back");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				//showAllDescriptions();
				break;
			case 2:
				//addNewDescription();
				break;
			case 3:
				showInitialOptions();
			break;
			default:
				manageMessages();
				break;
			}
		}
			private static void showAllDescriptions() {
					
					ArrayList<Message>allDescriptions=new ArrayList<>();
					for(Book b:books) {
						allDescriptions.addAll(b.getMessages());
					}
					if(allDescriptions.size()>0) {
						System.out.println("Book Name\t\t\tBook Number\t\t\t Book Price");
					    System.out.println("*****************************");
					    for(Message m: allDescriptions) {
					    	m.getDetails();
					    }
					    System.out.println("***************************");
					}
					    else {
					    	System.out.println("No Description Found");
					    }
					showInitialOptions();
					
				}
					private static void addNewDescription() {
						System.out.println("Type book code number you want to add descriptions");	
					    String number=scanner.next();
					    if(number.equals("")) {
					    	System.out.println("Please enter a book code");
					    	addNewDescription();
					    }
					    else {
					    	boolean doesExist=false;
					    	for(Book b:books) {
					    		if(b.getNumber().equals(number))
					    		{
					    			doesExist=true;
					    		}
					    }
					    	if(doesExist) {
					    		System.out.println("which Description are going to add?Sepaerate your description");
					    		String text=scanner.next();
					    		if(text.equals("")) {
					    			System.out.println("Please type your Book Description ");
					    		   addNewDescription();
					    		}
					    		else {
					    			id++;
					    			Message newDescription=new Message(text,number,id);
					    			for (Book b:books) {
					    				if(b.getNumber().equals(number)) {
					    					ArrayList<Message> newDescriptions=b.getMessages();
					    					newDescriptions.add(newDescription);
					    					
					    					Book currentBook=b;
					    					currentBook.setMessages(newDescriptions);
					    					books.remove(b);
					    					books.add(currentBook);
					    					System.out.println("Description Added Succesfully");
					    				}
					    			}
					    			manageMessages();
					    		}
					    	}
					    		else {
					    			System.out.println("There is no such book");
					    		}
				
			}
		

					}
}
		    	
		
		

