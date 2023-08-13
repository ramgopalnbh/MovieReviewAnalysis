package com.mra.external.services;

import com.mra.entities.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MovieMgmtService")
public interface MovieService {
    @GetMapping("/movie/{movieId}")
     Movie getMovie(@PathVariable Long movieId);
}
