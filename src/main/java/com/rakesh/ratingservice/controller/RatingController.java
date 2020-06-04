package com.rakesh.ratingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.ratingservice.entity.Rating;
@RestController
@RequestMapping("/ratings")
public class RatingController {

	@GetMapping("/{rating}")
	public Rating getRating(@PathVariable("rating") Double rating) {
		return new Rating("power",3);
		
	}
}
