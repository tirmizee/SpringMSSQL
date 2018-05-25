package com.tirmizee.backend.dao;

import com.tirmizee.repository.MemberRepository;
import com.tirmizee.repository.domain.Member;

public interface MemberDao extends MemberRepository {
	
	Member findByUsername(String username);
	
}
