package com.mra.service;

import com.mra.entities.Rating;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.FindAndModifyOptions;
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {
//    @Autowired
//    MongoOperations mongoOperations;
//
//    public Long getNextSequence(String seqName){
//        Rating counter =mongoOperations.findAndModify(Query.query(Criteria.where("_ratingId").is(seqName)),
//                new Update().inc("seq",1),
//                FindAndModifyOptions.options().returnNew(true).upsert(true),
//                Rating.class);
//        return counter.getSeq();
//    }
}
