package practica1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Picture, Long>{

	Picture findByTitle(String nombre);
	List<Picture> findByTitleAndAuthor(String nombre, Author autor);
}
