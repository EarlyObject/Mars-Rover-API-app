package com.earlyobject.repository;

import com.earlyobject.dto.HomeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends JpaRepository<HomeDto, Long> {
    HomeDto findByUserId(Long userId);
}
