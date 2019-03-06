package com.davidpark.board.member;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {
	int addMember(Member member);
	Member getMemberById(String memberId);
	int deleteAllMember();
	int selectNMembers();
}