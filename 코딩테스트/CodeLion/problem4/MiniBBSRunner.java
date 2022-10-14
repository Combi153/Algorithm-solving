package problem4;

public class MiniBBSRunner {

	public static void main(String[] args) {
		
		int key;
		
		ProgramManager programManager = new ProgramManager();
		PostManager postManager = new PostManager();

		while (true) {
			programManager.printStartMessage();
			key = programManager.getProgramKey();
			
			if (key == 1) {
				postManager.readPost();
			}
			
			else if (key == 2) {
				postManager.createPost();
			}
			
			else if (key == 0) {
				programManager.printEndMessage();
				break;
			}
		}
	}
}
