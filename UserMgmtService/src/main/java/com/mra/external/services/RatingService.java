package com.mra.external.services;

import com.mra.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "RatingMgmtService")
public interface RatingService {
    Rating getRating();
}
