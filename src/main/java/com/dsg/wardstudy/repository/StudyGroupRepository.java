package com.dsg.wardstudy.repository;

import com.dsg.wardstudy.domain.studyGroup.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {
}
