package com.davidpark.board.member;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class MemberDaoTest {
	@Autowired
	MemberDao memberDao;
	
	@Before
	public void setUp() {
	}		
	
	@Test
	/**
	 * 새로운 유저를 등록한다.
	 */
	public void addMember() {
		memberDao.deleteAllMember();
		
		Member newMember = new Member(0, "관리자", "admin", "admin");
		
		int nAddedUser = memberDao.addMember(newMember);
		
		assertThat(nAddedUser, is(1));
		
		Member registeredMember = memberDao.getMemberById(newMember.getMemberId());
		
		assertThat(newMember.getMemberId(), is(registeredMember.getMemberId()));
		assertThat(newMember.getMemberName(), is(registeredMember.getMemberName()));
		assertThat(newMember.getMemberPassword(), is(registeredMember.getMemberPassword()));
	}
	
	@Test
	/**
	 * DB에 등록된 모든 사용자를 삭제한다.
	 */
	public void deleteAllMember() {
		memberDao.deleteAllMember();
		assertThat(memberDao.getMemberById("admin"), is(nullValue()));
	}
	
	@Test
	/**
	 * DB에 등록된 모든 사용자 수를 조회한다.
	 */
	public void selectNMembers() {
		memberDao.deleteAllMember();
		assertThat(memberDao.selectNMembers(), is(0));
		
		Member member1 = new Member(0, "관리자", "admin", "admin");
		Member member2 = new Member(0, "테스트", "test", "xptmxm");
		Member member3 = new Member(0, "테스트2", "test2", "xptmxm2");
		
		memberDao.addMember(member1);
		assertThat(memberDao.selectNMembers(), is(1));
		memberDao.addMember(member2);
		assertThat(memberDao.selectNMembers(), is(2));
		memberDao.addMember(member3);
		assertThat(memberDao.selectNMembers(), is(3));
	}
}
