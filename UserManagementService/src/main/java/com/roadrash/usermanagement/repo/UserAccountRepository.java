package com.roadrash.usermanagement.repo;

import com.roadrash.usermanagement.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, UUID> {
    // Add custom query methods if needed
}
