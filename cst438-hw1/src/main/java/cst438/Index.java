package cst438;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Index {

	@Autowired
	RatingsRepository ratingsRepository;
	
	// Page loaded with instantiated MovieRating object when URL is .../rating
	@GetMapping("/movies/new")
	public String newPost(Model model) {
		System.out.println(new java.util.Date().toString());
		System.out.println(java.time.LocalTime.now().toString());
		MovieRating movieRating = new MovieRating();
		model.addAttribute("movieRating", movieRating);
		return "rating_form";
	}
	
	// Action taken after submitting form, process post
	@PostMapping("/movies/new")
	public String processRatingForm(@Valid MovieRating movieRating,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "rating_form";
		}
		// If no errors, save results to repository database
		System.out.println("GfG1");
		ratingsRepository.save(movieRating);
		return "rating_show";
	}
	
	// Get list of all movie reviews when GETting page
	// Sort by movie title
	@GetMapping("/movies")
	public String getAllReviews(Model model) {
		Iterable<MovieRating> ratingForms = ratingsRepository.findAllMovieRatingsOrderByTitleDateDesc();;
		model.addAttribute("ratingForms", ratingForms);
		return "rating_list";
	}
	
}
