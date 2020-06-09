package com.ex2.persistence;

import com.ex2.domain.MemberVO;

public interface MemberDAO {

    // 현재 시간 체크
    public String getTime();

    // 회원 입력
    public void insertMember(MemberVO memberVO);

    // 회원 아이디로 조회
    public MemberVO readMember(String userid) throws Exception;

    // 회원 아이디, 비밀번호로 조회
    public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
