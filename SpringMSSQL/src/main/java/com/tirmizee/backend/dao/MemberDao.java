package com.tirmizee.backend.dao;

import com.tirmizee.repository.domain.MemberRepository;
import com.tirmizee.repository.entities.Member;

public interface MemberDao extends MemberRepository {
	
	Member findByUsername(String username);
	
}
