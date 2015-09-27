package myhw2.data;


/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
	private final String title;
	private final int    year;
	private final String director;

	/**
	 * Initialize all object attributes.
	 */
	VideoObj(String title, int year, String director) {
		if (  (title == null)
				|| (director == null)
				|| (year <= 1800)
				|| (year >= 5000)) {
			throw new IllegalArgumentException();
		}
		this.title = title.trim();
		this.director = director.trim();
		this.year = year;
		if (  ("".equals(title))
				|| (" ".equals(title)))
			throw new IllegalArgumentException();
				
		if ( ("".equals(director))
				|| (" ".equals(director))) {
			throw new IllegalArgumentException();
		}
	
	}

	public String director() {
		// TODO
		return director;
	}

	public String title() {
		// TODO
		return title;
	}

	public int year() {
		// TODO
		return year;
	}

	public boolean equals(Object thatObject) {
		// TODO
		if (!(thatObject instanceof VideoObj)) {
			return false;
		}
		VideoObj that = (VideoObj) thatObject;
		if (!title.equals(that.title())) return false;
		if (year != that.year()) return false;
		if (!director.equals(that.director())) return false;
		return true;
	}

	public int hashCode() {
		// TODO
		int hash = 17;
		hash = 37*hash + title.hashCode();
		hash = 37*hash + year;
		hash = 37*hash + director.hashCode();
		return hash;
	}

	public int compareTo(Video that) {
		// TODO
		int titleDiff = title.compareTo(that.title());
		if (titleDiff != 0) {
			return titleDiff;
		}
		int yearDiff = Integer.compare (year, that.year());
		if (yearDiff != 0) {
			return yearDiff;
		}
		int directorDiff = director.compareTo(that.director());
		if (directorDiff != 0) {
			return directorDiff;
		}
		return 0;
	}

	public String toString() {
		// TODO
		//return "El Mariachi (1996) : Rodriguez";
		return title + " (" + year + ") : " + director;
	}
}
