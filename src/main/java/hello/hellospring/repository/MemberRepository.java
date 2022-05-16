package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);                 // 멤버 저장
    Optional<Member> findById(Long id);         // Optional 은 null 값을 감싸는 방법 중 하나. id, email 이 null 값일 경우 대비
    Optional<Member> findByName(String name);
    List<Member> findAll();                     // 지금까지 찾은 모든 list 반환
}
