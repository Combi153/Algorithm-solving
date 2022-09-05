package problem4;

import java.util.ArrayList;
import java.util.Scanner;
import formatexception.FormatException;

public class PostManager {
	
	private String inputTitle;
	private String inputAuthor;
	ArrayList<Post> bbs = new ArrayList<Post>();
	Scanner sc = new Scanner(System.in);
	
	public PostManager() {}
	
	// create
	public void createPost() {
		try {
			System.out.println("제목 :");
			this.inputTitle = sc.nextLine();
			checkPostFormat(inputTitle);
			
			System.out.println("작성자 :");
			this.inputAuthor = sc.nextLine();
			checkPostFormat(inputAuthor);
			
			setPost(inputTitle, inputAuthor);
			
		}catch (FormatException e) {
			System.out.println(e.getMessage());
			createPost();
		}		
	}
	
	//set
	public void setPost(String inputTitle, String inputAuthor) {
		bbs.add(new Post(inputTitle, inputAuthor));
	}
	
	//read
	public void readPost() {
		
		String space = "          ";
		System.out.println("== 게시물 리스트 ==");
		System.out.println("no" + space + "title" + space + "time");
		
		for (int i = 0; i<bbs.size(); i++) {
			int postNumberInt = i + 1;
			String postNumberStr = Integer.toString(postNumberInt);
			Post post = bbs.get(i);
			
			System.out.println(postNumberStr + space + post.getTitle() + space + post.getDate());
		}
	}
	
	// create - ExceptionCheck
	public void checkPostFormat(String content) throws FormatException {
		if (content == "") {
			throw new FormatException("입력받지 못했습니다. 다시 입력해주세요.");
		}
	}
}