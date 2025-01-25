package com.nray.tenpo.repository;

import com.nray.tenpo.entity.CallHistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallHistoryRepository extends CrudRepository<CallHistoryEntity, Long> {
}
