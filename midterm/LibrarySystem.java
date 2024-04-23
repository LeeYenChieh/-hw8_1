
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LibrarySystem {
	public static void main(String[] args) throws IOException{
		ArrayList<Book> books = new ArrayList<>();
		ArrayList<User> users = new ArrayList<>();
		TransactionHandler staffHandler = new StaffHandler();
		TransactionHandler borrowerHandler = new BorrowerHandler();
        File inputFile = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String line;
		String[] buffer;
		int number_of_book = 0;
		int number_of_user = 0;
		int id = 0;
		try {
			
			// Book Input
			while((line = reader.readLine()) != null) {
				try {
					line = reader.readLine();
					buffer = line.split(" ");
					if(buffer.length != 1) {
						System.out.println("dsafs");
						System.out.println("Error");
						continue;
					}
					number_of_book = Integer.parseInt(buffer[0]);
					break;
					
				} catch (Exception e) {
					System.out.println("Error");
					continue;
				}
			}
			for(int i = 0; i < number_of_book; i++) {
				line = reader.readLine();
				if (line == null) {
					System.out.println("Error");
					continue;
				}
				buffer = line.split(" ");
				if(buffer.length != 2) {
					System.out.println("Error");
					continue;
				}
				books.add(new Book(id, buffer[0], buffer[1]));
				id += 1;
			}
			
			
			
			// User Input
			while((line = reader.readLine()) != null) {
				try {
					line = reader.readLine();
					buffer = line.split(" ");
					if(buffer.length != 1) {
						System.out.println("Error");
						continue;
					}
					number_of_user = Integer.parseInt(buffer[0]);
					break;
					
				} catch (Exception e) {
					System.out.println("Error");
					continue;
				}
			}
			
			for(int i = 0; i < number_of_user; i++) {
				line = reader.readLine();
				if (line == null) {
					System.out.println("Error");
					continue;
				}
				buffer = line.split(" ");
				if(!buffer[0].equals("Staff") && !buffer[0].equals("Borrower")) {
					System.out.println("Error");
					continue;
				}
				if ((buffer[0].equals("Staff") && buffer.length != 2) || buffer[0].equals("Borrower") && buffer.length != 3) {
					System.out.println("Error");
					continue;
				}
				int idx = LibrarySystem.findUser(users, buffer[1]);
				if(idx != -1) {
					System.out.println("Error");
					continue;
				}
				else {
					try {
						int max_Num = -1;
						if(buffer[0].equals("Borrower")) {
							max_Num = Integer.parseInt(buffer[2]);
						}
						users.add(new User(buffer[0], buffer[1], max_Num));
					} catch (Exception e) {
						System.out.println("Error");
						continue;
					}
					
				}

			}
			
			
			
			// Transaction Input
			while((line = reader.readLine()) != null) {
				try {
					line = reader.readLine();
					buffer = line.split(" ");
					int idx = LibrarySystem.findUser(users, buffer[0]);
					if(idx == -1) {
						System.out.println("Error");
						continue;
					}
					else {
						User user1 = users.get(idx);
						if(user1.userType.equals("Staff")) {
							if(buffer[1].equals("addBook")) {
								if(buffer.length != 2) {
									System.out.println("Error");
									continue;
								}
								line = reader.readLine();
								buffer = line.split(" ");
								if(buffer.length != 2) {
									System.out.println("Error");
									continue;
								}
								int status = borrowerHandler.addBook(id, buffer[0], buffer[1], books);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
								id += 1;
							}
							else if(buffer[1].equals("removeBook")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								int status = borrowerHandler.removeBook(Integer.parseInt(buffer[2]), books);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("checkout")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								line = reader.readLine();
								buffer = line.split(" ");
								ArrayList<Book> checkouts = new ArrayList<>();
								int fail = 0;
								for(int k = 0; k < buffer.length; k++) {
									int idxx = LibrarySystem.findBook(books, Integer.parseInt(buffer[k]));
									if(idxx == -1) {
										fail = 1;
									}
									else {
										checkouts.add(books.get(idxx));
									}
								}
								int idxx = LibrarySystem.findUser(users, buffer[2]);
								if(idxx == -1) {
									System.out.println("Error");
									continue;
								}
								User user2 = users.get(idxx);
								int status = borrowerHandler.checkoutBooks(user1, user2, checkouts, books, users);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("return")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								int status = borrowerHandler.returnBook(user1, Integer.parseInt(buffer[2]), books);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("listAuthor")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								int status = borrowerHandler.listAuthor(buffer[2], books);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("listSubject")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								int status = borrowerHandler.listSubject(buffer[2], books);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("findChecked")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
//								int idx = LibrarySystem.findUser(users, buffer[2]);
//								if(idx == -1) {
//									System.out.println("Error");
//									continue;
//								}
//								User user2 = users.get(idx);
								int status = borrowerHandler.findChecked(buffer[0], buffer[2], users);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("Borrower")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								int idxx = LibrarySystem.findBook(books, Integer.parseInt(buffer[2]));
								if(idxx == -1) {
									System.out.println("Error");
									continue;
								}
								Book book2 = books.get(idxx);
								int status = borrowerHandler.findBorrower(book2);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
						}
						else if(user1.userType.equals("Staff")) {
							if(buffer[1].equals("addBook")) {
								if(buffer.length != 2) {
									System.out.println("Error");
									continue;
								}
								line = reader.readLine();
								buffer = line.split(" ");
								if(buffer.length != 2) {
									System.out.println("Error");
									continue;
								}
								int status = staffHandler.addBook(id, buffer[0], buffer[1], books);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
								id += 1;
							}
							else if(buffer[1].equals("removeBook")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								int status = staffHandler.removeBook(Integer.parseInt(buffer[2]), books);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("checkout")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								line = reader.readLine();
								buffer = line.split(" ");
								ArrayList<Book> checkouts = new ArrayList<>();
								int fail = 0;
								for(int k = 0; k < buffer.length; k++) {
									int idxx = LibrarySystem.findBook(books, Integer.parseInt(buffer[k]));
									if(idxx == -1) {
										fail = 1;
									}
									else {
										checkouts.add(books.get(idxx));
									}
								}
								int idxx = LibrarySystem.findUser(users, buffer[2]);
								if(idxx == -1) {
									System.out.println("Error");
									continue;
								}
								User user2 = users.get(idxx);
								int status = staffHandler.checkoutBooks(user1, user2, checkouts, books, users);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("return")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								int status = staffHandler.returnBook(user1, Integer.parseInt(buffer[2]), books);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("listAuthor")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								int status = staffHandler.listAuthor(buffer[2], books);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("listSubject")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								int status = staffHandler.listSubject(buffer[2], books);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("findChecked")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
//								int idx = LibrarySystem.findUser(users, buffer[2]);
//								if(idx == -1) {
//									System.out.println("Error");
//									continue;
//								}
//								User user2 = users.get(idx);
								int status = staffHandler.findChecked(buffer[0], buffer[2], users);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
							else if(buffer[1].equals("Borrower")) {
								if(buffer.length != 3) {
									System.out.println("Error");
									continue;
								}
								int idxx = LibrarySystem.findBook(books, Integer.parseInt(buffer[2]));
								if(idxx == -1) {
									System.out.println("Error");
									continue;
								}
								Book book2 = books.get(idxx);
								int status = staffHandler.findBorrower(book2);
								if(status == 1) { 
									System.out.println("Error");
									continue;
								}
							}
						}
					}
					
				} catch (Exception e) {
					System.out.println("Error");
					continue;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error");
		}
		
    }
	
	public static int findBook(ArrayList<Book> books, String Author, String Subject) {
		int idx = -1;
		for(int i = 0; i < books.size(); i++) {
			if(Author.equals(books.get(i).Author) && Subject.equals(books.get(i).Subject)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	public static int findBook(ArrayList<Book> books, int bookId) {
		int idx = -1;
		for(int i = 0; i < books.size(); i++) {
			if(bookId == books.get(i).id) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	public static int findUser(ArrayList<User> users, String userName) {
		int idx = -1;
		for(int i = 0; i < users.size(); i++) {
			if(userName.equals(users.get(i).userName)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
}
