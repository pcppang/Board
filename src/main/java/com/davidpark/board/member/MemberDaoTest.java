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
		assertThat(memberDao.selectNMembers(), is(0));
		
		Member newMember = new Member(0, "관리자", "admin", "admin");
		
		int nAddedUser = memberDao.addMember(newMember);
		
		assertThat(nAddedUser, is(1));
		assertThat(memberDao.selectNMembers(), is(1));
		
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
	
}
