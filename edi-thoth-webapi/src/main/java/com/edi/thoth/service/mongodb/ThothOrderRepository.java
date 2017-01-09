package com.edi.thoth.service.mongodb;

import com.thoth.domain.ThothOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ThothOrderRepository extends MongoRepository<ThothOrder, String>
{

}
