package com.fpoly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
}