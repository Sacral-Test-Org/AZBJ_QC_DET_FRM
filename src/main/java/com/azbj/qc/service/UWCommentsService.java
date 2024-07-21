package com.azbj.qc.service;

import com.azbj.qc.repository.UWCommentsRepository;
import com.azbj.qc.model.UWComment;
import com.azbj.qc.model.RICODetail;
import com.azbj.qc.dto.UWCommentDTO;
import com.azbj.qc.dto.RICODetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UWCommentsService {

    @Autowired
    private UWCommentsRepository uwCommentsRepository;

    public List<UWCommentDTO> getComments(String policyRef, String userId) {
        List<UWComment> comments = uwCommentsRepository.findCommentsByPolicyRef(policyRef);
        // Apply business logic to filter comments based on user profile and permissions
        return comments.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<RICODetailDTO> getRICODetails(String policyRef) {
        List<RICODetail> riCoDetails = uwCommentsRepository.findRICODetailsByPolicyRef(policyRef);
        return riCoDetails.stream().map(this::convertToRICODetailDTO).collect(Collectors.toList());
    }

    public List<UWComment> fetchComments(String policyId) {
        return uwCommentsRepository.findByPolicyId(policyId);
    }

    public UWComment saveComment(UWComment comment) {
        return uwCommentsRepository.save(comment);
    }

    public List<UWComment> getComments(String policyNumber, String userProfile) {
        List<UWComment> comments = uwCommentsRepository.findByPolicyNumber(policyNumber);
        if ("SUPERVISOR".equals(userProfile)) {
            comments.addAll(uwCommentsRepository.findAdditionalComments(policyNumber));
        }
        return comments;
    }

    private UWCommentDTO convertToDTO(UWComment comment) {
        return new UWCommentDTO(comment.getId(), comment.getPolicyRef(), comment.getComment(), comment.getUserId(), comment.getDate());
    }

    private RICODetailDTO convertToRICODetailDTO(RICODetail riCoDetail) {
        return new RICODetailDTO(riCoDetail.getUserId(), riCoDetail.getCoDate(), riCoDetail.getUwComments());
    }
}
