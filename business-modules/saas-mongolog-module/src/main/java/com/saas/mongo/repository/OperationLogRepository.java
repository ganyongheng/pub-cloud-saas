package com.saas.mongo.repository;

import com.saas.mongo.entity.OperationLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationLogRepository extends MongoRepository<OperationLog, String> {

}
