package com.edi.thoth.service.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.edi.thoth.domain.ClientUsers;

@Component
public interface ClientUsersRepository extends MongoRepository<ClientUsers, ObjectId>
{
	ClientUsers findByips(String ip);


	ClientUsers findBycheckID(String serviceName);
}
