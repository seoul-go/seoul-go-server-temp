//package go.seoul.serv.service;
//
//import go.seoul.serv.dto.MemberDTO;
//import go.seoul.serv.entity.MemberEntity;
//import go.seoul.serv.repository.MemberRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Optional;
//
//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
//import static org.hamcrest.Matchers.any;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//public class MemberServiceTest {
//    @Mock
//    private MemberRepository memberRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private MemberService memberService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void registerMember_Success() {
//        // Arrange
//        MemberDTO memberDto = new MemberDTO("testUser", "password", "Test", "Tester", 25);
//        when(memberRepository.findByUsername(anyString())).thenReturn(Optional.empty());
//        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
//        when(memberRepository.save(any(MemberEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        // Act
//        MemberDTO result = memberService.registerMember(memberDto);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(memberDto.getUsername(), result.getUsername());
//        verify(memberRepository).save(any(MemberEntity.class));
//    }
//
//    @Test
//    void registerMember_UsernameAlreadyExists_ThrowsException() {
//        // Arrange
//        MemberDTO memberDto = new MemberDTO("testUser", "password", "Test", "Tester", 25);
//        when(memberRepository.findByUsername("testUser")).thenReturn(Optional.of(new MemberEntity()));
//
//        // Act & Assert
//        assertThrows(RuntimeException.class, () -> {
//            memberService.registerMember(memberDto);
//        });
//    }
//}
