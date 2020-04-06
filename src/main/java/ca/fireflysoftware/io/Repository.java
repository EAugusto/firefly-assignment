package ca.fireflysoftware.io;

public enum Repository {

	DEFAULT("src/main/resources/");
	
	private String path;
	
	private Repository(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
	
}