package go.seoul.serv.service;

import go.seoul.serv.dto.MemberDTO;
import go.seoul.serv.entity.MemberEntity;
import go.seoul.serv.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberDTO registerMember(MemberDTO memberDto) {
        log.info("회원 가입 시도: {}", memberDto.getUsername());
        memberRepository.findByUsername(memberDto.getUsername()).ifPresent(existingUser -> {
            log.error("사용자 이름 {}이(가) 이미 사용중입니다.", memberDto.getUsername());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "사용자 이름이 이미 사용되었습니다.");
        });

        MemberEntity member = MemberEntity.builder()
                .username(memberDto.getUsername())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .name(memberDto.getName())
                .nickName(memberDto.getNickName())
                .age(memberDto.getAge())
                .build();
        member = memberRepository.save(member);
        return memberDto;
    }
//    private MemberDTO toMemberDTO(MemberEntity member) {
//        return new MemberDTO(
//                member.getUsername(),
//                null, // 비밀번호는 반환하지 않습니다.
//                member.getName(),
//                member.getNickName(),
//                member.getAge()
//        );
//    }

    public String loginMember(MemberDTO memberDto) {
        MemberEntity member = memberRepository.findByUsername(memberDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        if (passwordEncoder.matches(memberDto.getPassword(), member.getPassword())) {
            return "Login successful"; // 성공적으로 로그인되었을 때 반환될 메시지
        } else {
            throw new BadCredentialsException("잘못된 사용자 이름/비밀번호가 제공되었습니다.");
        }
    }


    public MemberDTO getMemberInfo(String username) {
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return MemberDTO.builder()
                .username(member.getUsername())
                .name(member.getName())
                .nickName(member.getNickName())
                .age(member.getAge())
                .build();
    }

    public MemberDTO updateMemberInfo(MemberDTO memberDto, String username) {
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        member.setName(memberDto.getName());
        member.setNickName(memberDto.getNickName());
        member.setAge(memberDto.getAge());
        if (memberDto.getPassword() != null && !memberDto.getPassword().isEmpty()) {
            member.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        }
        memberRepository.save(member);

        return MemberDTO.builder()
                .username(member.getUsername())
                .name(member.getName())
                .nickName(member.getNickName())
                .age(member.getAge())
                .build();
    }

    public void deleteMember(String username) {
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        memberRepository.delete(member);
    }
}
