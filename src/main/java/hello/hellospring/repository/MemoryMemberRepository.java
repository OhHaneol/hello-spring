package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()      // stream(): Java8 부터 지원, 컬렉션과 배열 등 저장된 요소들을 하나씩 참조하며 반복적인 처리 가능. 불필요한 for문 필요X
                .filter(member -> member.getName().equals(name))    //  람다 사용, member 에서 name 을 가져와서 입력된 name과 비교
                .findAny();     //  하나라도 찾으면 return
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //  member 는 Map 인데 반환값 List임. 걍 ㄱㄱ.
    }

    public void clearStore() {
        store.clear();
    }
}
