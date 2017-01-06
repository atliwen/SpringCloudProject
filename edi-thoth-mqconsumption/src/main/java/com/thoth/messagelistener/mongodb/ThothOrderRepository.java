package com.thoth.messagelistener.mongodb;

import com.thoth.domain.ThothOrder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


@Component
public interface ThothOrderRepository extends MongoRepository<ThothOrder, ObjectId>
{

}
