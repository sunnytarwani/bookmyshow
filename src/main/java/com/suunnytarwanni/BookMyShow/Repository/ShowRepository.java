package com.suunnytarwanni.BookMyShow.Repository;

import com.suunnytarwanni.BookMyShow.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    Optional<Show> findById(Long id);
}
