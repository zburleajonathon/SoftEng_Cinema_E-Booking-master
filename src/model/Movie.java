
package termproj;

public class Movie {
    String name;
    int runtime;
    String trailer;
    String cast;
    String rating;
    String genre;
    String review;

    // Constructors
    Movie() {
		name = "";
		runtime = 0;
		trailer = "";
		cast = "";
		rating = "";
		genre = "";
		review = "";
    }
    Movie(String name, int runtime, String trailer, String cast, String rating, String genre, String review) {
		this.name = name;
		this.runtime = runtime;
		this.trailer = trailer;
		this.cast = cast;
		this.rating = rating;
		this.genre = genre;
		this.review = review;
    }
    Movie(String name){
		this.name = name;
    }
    
    // Getters
    String getName() {
		return name;
    }
    int getRuntime(){
		return runtime;
    }
    String getTrailer() {
		return trailer;
    }
    String getCast() {
		return cast;
    }
    String getRating() {
		return rating;
    }
    String getGenre() {
		return genre;
    }
    String getReview() {
		return review;
    }
    
    // Setters
    void setName(String name) {
		this.name = name;
    }
    void setRuntime(int runtime) {
		this.runtime = runtime;
    }
    void setTrailer(String trailer) {
		this.trailer = trailer;
    }
    void setCast(String cast) {
		this.cast = cast;
    }
    void setRating(String rating) {
		this.rating = rating;
    }
    void setGenre(String genre) {
		this.genre = genre;
    }
    void setReview(String review) {
		this.review = review;
    }
    
} // Movie


