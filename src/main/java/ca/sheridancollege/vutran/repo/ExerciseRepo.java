package ca.sheridancollege.vutran.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.vutran.beans.Exercise;

public interface ExerciseRepo extends JpaRepository<Exercise, Long> {

}
