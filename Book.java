import java.util.ArrayList;
public class Book {
	     private String name;
	     private String number;
	     private ArrayList<Message> messages;
	     private String price;
	 
	     public Book(String name,ArrayList <Message> messages,String number,String price) {
	            this.name=name;
	            this.number=number;
	            this.messages=messages;
	            this.price=price; 
	}
	     public Book(String name,String number,ArrayList <Message> messages,String price) {
	         this.name=name;
	         this.number=number;
	         this.messages=new ArrayList();
	         this.price=price; 
	     }
	     public void getDetails() {
	    		System.out.println(this.name+"\t\t"+this.number+""+"\t\t"+this.price+"\t\t");
	}
	     public String getName() {
	    	 return name;
	     }
	     public void setName(String name) {
	    	 this.name=name;
	     }
	     public String getNumber() {
	    	 return number;
	     }
	     public void setNumber(String number) {
	    	 this.number=number;
	     }
	     public ArrayList<Message> getMessages() {
	    	 return messages;
	     }
	     public void setMessages(ArrayList messages) {   //ArrayList<Message> message
	    	 this.messages=messages;
	     }
	     public String getPrice(){
	    	 return price;
	     }
	     public void setPrice(String price) {
	    	 this.price=price;
	     }
	   
	}

