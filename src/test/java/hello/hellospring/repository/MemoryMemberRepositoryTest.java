package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();   // MemoryMemberRepository 만 테스트 하니까 인터페이스 말고 해당으로 바꿔줌

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        //  spring 이라는 이름으로 정보 저장
        member.setName("spring");

        //  id 저장
        repository.save(member);

        //  id 꺼내기
        //  Optional<Member> result = repository.findById(member.getId());
        Member result = repository.findById(member.getId()).get();  //  get() 을 쓰면 Optional 을 까서 꺼낼 수 있음

        //  result 와 member 값 비교
        //  System.out.println("result = " + (result == member));
        //  Assertions.assertEquals(member, result);    // junit 버전_Assertions.assertEquals(expected_기대값, actual_실제값) : 일치 여부 검증
        assertThat(member).isEqualTo(result);    //  assertj 버전, [Option]+[Enter] 에서 static 으로 assertThat 만 쳐서 사용 가능
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        // result(spring1) == member1
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        //  정보 2개 저장
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //  원래 반환 타입인 List 형태로 result 저장
        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
