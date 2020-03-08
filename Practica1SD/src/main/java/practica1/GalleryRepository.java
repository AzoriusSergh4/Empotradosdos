package practica1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import practica1.author.Author;
import practica1.picture.Picture;

public interface GalleryRepository extends JpaRepository<Picture, Long>{

	Picture findByTitle(String name);
	List<Picture> findByTitleAndAuthor(String name, Author author);
}
