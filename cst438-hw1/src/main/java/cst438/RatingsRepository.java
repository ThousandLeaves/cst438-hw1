package cst438;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface RatingsRepository extends CrudRepository<MovieRating, Long> {

	@Query("SELECT m FROM MovieRating m ORDER BY title, date DESC")
	
	List<MovieRating> findAllMovieRatingsOrderByTitleDateDesc();
	
}
