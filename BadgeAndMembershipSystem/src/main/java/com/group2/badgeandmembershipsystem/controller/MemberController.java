package com.group2.badgeandmembershipsystem.controller;


import com.group2.badgeandmembershipsystem.dto.*;
import com.group2.badgeandmembershipsystem.exception.payload.ApiResponse;
import com.group2.badgeandmembershipsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getMembers(){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getAllMembers());
    }
    @PostMapping
    public ResponseEntity<MemberDTO> addNewMember(@RequestBody RegistrationDTO member) throws MessagingException {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.createNewMember(member));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable long id, @RequestBody UpdateMemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.updateMember(id,memberDTO));
    }
    @PatchMapping("/{id}/password")
    public ResponseEntity<ApiResponse> changePassword(@PathVariable long id, @RequestBody PasswordDTO passwordDTO){
        memberService.changePassword(id,passwordDTO);
        ApiResponse response = ApiResponse.builder().message("Password changed successfully").success(true).status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PreAuthorize("hasAnyRole('ROLE_STAFF','ROLE_FACULTY','ROLE_STUDENT','ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMember(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getMember(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteMember(@PathVariable long id){
        memberService.deleteMember(id);
        ApiResponse response = ApiResponse.builder().message("Member is deleted successfully").success(true).status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{memberId}/transactions")
    public ResponseEntity<List<TransactionDTO>> findTransactionsByMemberId(@PathVariable Long memberId){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findTransactionsByMemberId(memberId));
    }
    @GetMapping("/{memberId}/plans")
    public ResponseEntity<List<PlanDTO>> findPlansByMemberId(@PathVariable Long memberId){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findPlansByMemberId(memberId));
    }
    @GetMapping("/{memberId}/badges")
    public ResponseEntity<List<BadgeDTO>> findBadgesByMemberId(@PathVariable Long memberId){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findBadgesByMemberId(memberId));
    }
    @GetMapping("/{memberId}/badges/filterBy")
    public ResponseEntity<List<BadgeDTO>> findBadgesByMemberId(@PathVariable Long memberId, @RequestParam String status){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.filterActiveBadgesOfMember(memberId,status));
    }
    @GetMapping("/{memberId}/memberships")
    public ResponseEntity<List<MembershipDTO>> findMembershipsByMemberId(@PathVariable Long memberId){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findMembershipsByMemberId(memberId));
    }
    @GetMapping("/{memberId}/memberships/filterBy")
    public ResponseEntity<List<MembershipDTO>> getAllCheckerMemberships(@PathVariable Long memberId, @RequestParam String membershipType){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getAllCheckerMemberships(memberId,membershipType));
    }
}
