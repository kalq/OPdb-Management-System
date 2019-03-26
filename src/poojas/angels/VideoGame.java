package poojas.angels;

public class VideoGame {

	private String name;
	private String genre;
	private int year;
	private double rating;
	private ESRB esrb;
	private Platform[] platform;
	private Company[] publishers;
	private Company[] developers;

	public VideoGame() {
		// TODO - implement VideoGame.VideoGame
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param genre
	 * @param year
	 * @param rating
	 * @param esrb
	 * @param platforms
	 * @param publishers
	 * @param developers
	 */
	public VideoGame(String name, String genre, int year, double rating, ESRB esrb, Platform[] platforms, Company[] publishers, Company[] developers) {
		// TODO - implement VideoGame.VideoGame
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

	public String getGenre() {
		return this.genre;
	}

	/**
	 * 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return this.year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	public double getRating() {
		return this.rating;
	}

	/**
	 * 
	 * @param rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	public ESRB getEsrb() {
		return this.esrb;
	}

	/**
	 * 
	 * @param esrb
	 */
	public void setEsrb(ESRB esrb) {
		this.esrb = esrb;
	}

	public Platform[] getPlatform() {
		return this.platform;
	}

	/**
	 * 
	 * @param platform
	 */
	public void setPlatform(Platform[] platform) {
		this.platform = platform;
	}

	public Company[] getPublishers() {
		return this.publishers;
	}

	/**
	 * 
	 * @param publishers
	 */
	public void setPublishers(Company[] publishers) {
		this.publishers = publishers;
	}

	public Company[] getDevelopers() {
		return this.developers;
	}

	/**
	 * 
	 * @param developers
	 */
	public void setDevelopers(Company[] developers) {
		this.developers = developers;
	}

	public String toString() {
		// TODO - implement VideoGame.toString
		throw new UnsupportedOperationException();
	}

}