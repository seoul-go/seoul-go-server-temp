package go.seoul.serv.service;

import go.seoul.serv.dto.MemberDTO;
import go.seoul.serv.entity.MemberEntity;
import go.seoul.serv.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void whenRegisterWithExistingUsername_thenResponseStatusException() {
        // given
        MemberDTO memberDto = new MemberDTO("testuser", "password123", "Test", "Tester", 30);
        when(memberRepository.findByUsername("testuser")).thenReturn(Optional.of(mock(MemberEntity.class)));

        // when
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            memberService.registerMember(memberDto);
        });

        // then
        assertTrue(exception.getMessage().contains("사용자 이름이 이미 사용되었습니다."));
        assertEquals(HttpStatus.BAD_REQUEST, ((ResponseStatusException) exception).getStatusCode());
    }

    @Test
    public void whenRegisterWithNewUsername_thenSuccess() {
        // given
        MemberDTO memberDto = new MemberDTO("newuser", "password123", "New", "User", 25);
        when(memberRepository.findByUsername("newuser")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");
        when(memberRepository.save(any(MemberEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // when
        MemberDTO savedMemberDto = memberService.registerMember(memberDto);

        // then
        assertNotNull(savedMemberDto);
        verify(memberRepository).save(any(MemberEntity.class));
        assertEquals("newuser", savedMemberDto.getUsername());
    }
}
