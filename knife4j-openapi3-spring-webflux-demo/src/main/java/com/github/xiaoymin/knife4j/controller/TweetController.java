/*
 *
 *  * Copyright 2019-2020 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.github.xiaoymin.knife4j.controller;

import com.github.xiaoymin.knife4j.dto.TweetDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by rajeevkumarsingh on 08/09/17.
 */
@RestController
public class TweetController {


	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "get All Tweets") })
	@GetMapping("/tweets")
	public Flux<TweetDTO> getAllTweets() {
		List<TweetDTO> tweetDTOS=new ArrayList<>();
		tweetDTOS.add(new TweetDTO("123"+ UUID.randomUUID()));
		tweetDTOS.add(new TweetDTO("456"+ UUID.randomUUID()));
		return Flux.just(tweetDTOS.toArray(new TweetDTO[]{}));
	}

	@PostMapping("/tweets")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "create Tweets") })
	public Mono<TweetDTO> createTweets(@Valid @RequestBody TweetDTO tweetDTO) {
		return Mono.just(tweetDTO);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "get Tweet By Id"),
			@ApiResponse(responseCode = "404", description = "tweet not found") })
	@GetMapping("/tweets/{id}")
	public Mono<ResponseEntity<TweetDTO>> getTweetById(@PathVariable(value = "id") String tweetId) {
		return Mono.just(ResponseEntity.ok(new TweetDTO("123"+System.currentTimeMillis()+",id:"+tweetId)));
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "update Tweet"),
			@ApiResponse(responseCode = "404", description = "tweet not found") })
	@PutMapping("/tweets/{id}")
	public Mono<ResponseEntity<TweetDTO>> updateTweet(@PathVariable(value = "id") String tweetId,
			@Valid @RequestBody TweetDTO tweetDTO) {
		return Mono.just(ResponseEntity.ok(new TweetDTO("123"+System.currentTimeMillis()+",id:"+tweetId)));
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "delete Tweet"),
			@ApiResponse(responseCode = "404", description = "tweet not found") })
	@DeleteMapping("/tweets/{id}")
	public Mono<ResponseEntity<Void>> deleteTweet(@PathVariable(value = "id") String tweetId) {
		return Mono.empty();
	}

	@Operation(description = "Tweets are Sent to the client as Server Sent Events", responses = {
			@ApiResponse(responseCode = "200", description = "stream All Tweets") })
	@GetMapping(value = "/stream/tweets", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<TweetDTO> streamAllTweets() {
		List<TweetDTO> tweetDTOS=new ArrayList<>();
		tweetDTOS.add(new TweetDTO("123"+ UUID.randomUUID()));
		tweetDTOS.add(new TweetDTO("456"+ UUID.randomUUID()));
		return Flux.just(tweetDTOS.toArray(new TweetDTO[]{}));
	}

}
