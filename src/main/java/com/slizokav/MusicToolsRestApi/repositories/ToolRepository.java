package com.slizokav.MusicToolsRestApi.repositories;

import com.slizokav.MusicToolsRestApi.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Integer> {
}
