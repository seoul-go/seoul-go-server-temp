package go.seoul.serv.controller;

import go.seoul.serv.dto.MemberDTO;
import go.seoul.serv.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/v1/users")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public ResponseEntity<MemberDTO> registerMember(@RequestBody MemberDTO memberDto) {
        MemberDTO newMember = memberService.registerMember(memberDto);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginMember(@RequestBody MemberDTO memberDto) {
        String token = memberService.loginMember(memberDto);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/me")
    public ResponseEntity<MemberDTO> getMemberInfo(Principal principal) {
        MemberDTO memberDto = memberService.getMemberInfo(principal.getName());
        return ResponseEntity.ok(memberDto);
    }

    @PatchMapping("/me")
    public ResponseEntity<MemberDTO> updateMemberInfo(@RequestBody MemberDTO memberDto, Principal principal) {
        MemberDTO updatedMember = memberService.updateMemberInfo(memberDto, principal.getName());
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/me")
    public ResponseEntity<?> deleteMember(Principal principal) {
        memberService.deleteMember(principal.getName());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
