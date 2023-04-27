package com.roadrash.usermanagement.repo;

import com.roadrash.usermanagement.domain.UserAccountDomain;
import com.roadrash.usermanagement.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
