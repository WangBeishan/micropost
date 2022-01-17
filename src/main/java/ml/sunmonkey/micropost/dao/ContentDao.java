package ml.sunmonkey.micropost.dao;

import ml.sunmonkey.micropost.model.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentDao extends CrudRepository<Content, Long> {

    List<Content> findContentByUserId(Long userId);
}
