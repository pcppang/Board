package com.davidpark.board.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDao implements MemberRepository {
	@Autowired SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
	    this.sqlSession = sqlSession;
	}
	
	@Override
	public int addMember(Member member) {
		int result = 0;
		
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		result = repository.addMember(member);

		return result;
	}

	@Override
	public Member getMemberById(String memberId) {
		Member result = null;
		
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		result = repository.getMemberById(memberId);
		
		return result;
	}

	@Override
	public int deleteAllMember() {
		int result = 0;
		
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		result = repository.deleteAllMember();
		
		return result;
	}

	@Override
	public int selectNMembers() {
		int result = 0;
		
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		result = repository.selectNMembers();
		
		return result;
	}
}
