package com.filmstar.apps.backoffice;

import com.filmstar.domain.director.Director;
import com.filmstar.domain.director.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for querying a list of directors.
 */
@RestController
@RequestMapping(value = "/api/backoffice/directors")
@Qualifier("backoffice")
@CrossOrigin("*")
public class QueryDirectorListGetController {

	@Autowired
	private DirectorRepository directorRepository;

	/**
	 * Retrieves a paginated list of directors.
	 *
	 * @param page the page number (default is 0)
	 * @param size the number of items per page (default is 10)
	 * @return a PaginatedDirectorResponse containing the list of serialized directors,
	 *         the current page number, the page number of the previous page (if exists),
	 *         and the page number of the next page (if exists)
	 */
	@GetMapping
	public PaginatedDirectorResponse execute(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
	) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Director> directorPage = directorRepository.findAll(pageRequest);

		List<SerializedDirector> serializedDirectors = directorPage.getContent().stream()
				.map(SerializedDirector::from)
				.collect(Collectors.toList());

		return new PaginatedDirectorResponse(
				serializedDirectors,
				directorPage.getNumber(),      // current page
				directorPage.hasPrevious() ? directorPage.getNumber() - 1 : null,  // before
				directorPage.hasNext() ? directorPage.getNumber() + 1 : null      // after
		);
	}
}
