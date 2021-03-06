package kr.green.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public MemberVO getMember(String id) {
		
		return memberDao.getMember(id);
	}

	@Override
	public MemberVO signin(MemberVO logInfo) {
	    MemberVO user = memberDao.getMember(logInfo.getId());
	    if(user != null && passwordEncoder.matches(logInfo.getPw(), user.getPw()))
	    	return user;
		return null;
	}

}
