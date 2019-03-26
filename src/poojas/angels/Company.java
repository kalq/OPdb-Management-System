package poojas.angels;

public class Company {

	private String name;
	private VideoGame[] published;
	private VideoGame[] developed;

	public Company() {
		// TODO - implement Company.Company
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public Company(String name) {
		// TODO - implement Company.Company
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public VideoGame[] getPublished() {
		return this.published;
	}

	/**
	 * 
	 * @param published
	 */
	public void setPublished(VideoGame[] published) {
		this.published = published;
	}

	public VideoGame[] getDeveloped() {
		return this.developed;
	}

	/**
	 * 
	 * @param developed
	 */
	public void setDeveloped(VideoGame[] developed) {
		this.developed = developed;
	}

	public String toString() {
		// TODO - implement Company.toString
		throw new UnsupportedOperationException();
	}

}