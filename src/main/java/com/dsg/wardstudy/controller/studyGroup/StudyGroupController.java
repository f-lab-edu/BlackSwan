package com.dsg.wardstudy.controller.studyGroup;

import com.dsg.wardstudy.domain.studyGroup.StudyGroup;
import com.dsg.wardstudy.dto.studyGroup.StudyGroupRequest;
import com.dsg.wardstudy.dto.studyGroup.StudyGroupResponse;
import com.dsg.wardstudy.service.studyGroup.StudyGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    // 스터디그룹 등록(리더만)
    @PostMapping("/user/{userId}/study-group")
    public ResponseEntity<StudyGroupResponse> create(
            @PathVariable("userId") Long userId,
            @RequestBody StudyGroupRequest studyGroupRequest) {
        log.info("studyGroup create, userId: {}, studyGroupRequest: {}", userId, studyGroupRequest);
        return new ResponseEntity<>(studyGroupService.create(userId, studyGroupRequest), HttpStatus.CREATED);
    }

    // 스터디그룹 상세보기
    @GetMapping("/study-group/{studyGroupId}")
    public ResponseEntity<StudyGroupResponse> getById(@PathVariable("studyGroupId") Long studyGroupId) {
        log.info("studyGroup getById, studyGroupId: {}", studyGroupId);
        return ResponseEntity.ok(studyGroupService.getById(studyGroupId));
    }

    // 스터디그룹 전체조회
    @GetMapping("/study-group")
    public ResponseEntity<List<StudyGroupResponse>> getAll() {
        log.info("studyGroup getAll");
        return ResponseEntity.ok(studyGroupService.getAll());
    }

    // 사용자가 참여한 스터디그룹 조회
    @GetMapping("/user/{userId}/study-group")
    public ResponseEntity<List<StudyGroupResponse>> getAllByUserId(
            @PathVariable("userId") Long userId
    ) {
        log.info("studyGroup getAllByUserId, userId: {}", userId);
        return ResponseEntity.ok(studyGroupService.getAllByUserId(userId));
    }

    // 스터디그룹 수정(리더만)
    @PutMapping("/user/{userId}/study-group/{studyGroupId}")
    public Long updateById(
            @PathVariable("userId") Long userId,
            @PathVariable("studyGroupId") Long studyGroupId,
            @RequestBody StudyGroupRequest studyGroupRequest) {
        log.info("studyGroup updateById, studyGroupId: {}, ", studyGroupId);
        return studyGroupService.updateById(userId, studyGroupId, studyGroupRequest);
    }

    // 스터디그룹 삭제(리더만)
    @DeleteMapping("/study-group/{studyGroupId}")
    public ResponseEntity<String> deleteById(@PathVariable("studyGroupId") Long studyGroupId) {
        log.info("studyGroup deleteById, studyGroupId: {}", studyGroupId);
        studyGroupService.deleteById(studyGroupId);
        return new ResponseEntity<>("a study-group successfully deleted!", HttpStatus.OK);
    }
}
