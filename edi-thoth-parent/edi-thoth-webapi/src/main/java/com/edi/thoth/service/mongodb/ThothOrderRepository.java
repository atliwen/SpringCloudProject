package com.edi.thoth.service.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.edi.thoth.domain.ThothOrder;

@Component
public interface ThothOrderRepository extends MongoRepository<ThothOrder, ObjectId>
{

}
