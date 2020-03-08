package practica1.picture;

import org.springframework.data.jpa.repository.JpaRepository;
import practica1.author.Author;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findByTitle(String name);
    List<Picture> findByTitleAndAuthor(String name, Author author);
}
