package org.ddestrei.p.repository;

import org.ddestrei.p.model.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p")
    public Page<Post> findAll(Pageable pageable);

    @Query("select p from Post p where id = :id ")
    public Optional<Post> findById(@Param("id") Long id);

}
