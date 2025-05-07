package com.OnlineTutor.tutor.User.specificgoal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificgoalRepo extends JpaRepository <SpecificgoalModel,Long>{
}
