package com.ex2;

import com.ex2.domain.MemberVO;
import com.ex2.persistence.MemberDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/applicationContext.xml"})
public class MemberDAOTest {

    @Inject
    private MemberDAO memberDAO;

    // 현재 시간 출력 테스트
    @Test
    public void testTime() throws Exception {
        System.out.println(memberDAO.getTime());
    }

    // 회원 입력 테스트
    @Test
    public void testInsertMember() throws Exception {
        MemberVO m00 = new MemberVO();
        m00.setUserid("user00");
        m00.setUserpw("user00");
        m00.setUsername("user00");
        m00.setEmail("user00@example.com");

        memberDAO.insertMember(m00);
    }

    // 회원 조회 테스트 1 : 아이디
    @Test
    public void testReadMember() throws Exception {
        memberDAO.readMember("user00");
    }

    // 회원 조회 테스트 2 : 아이디 + 비밀번호
    @Test
    public void testReadWithPW() throws Exception {
        memberDAO.readWithPW("user00", "user00");
    }

}
