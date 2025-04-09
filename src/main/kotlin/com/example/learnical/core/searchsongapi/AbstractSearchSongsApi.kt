package com.example.learnical.core.searchsongapi

import org.springframework.web.client.RestTemplate

abstract class AbstractSearchSongsApi(val restTemplate : RestTemplate) : SearchSongsApi {

}