package com.mock.server.controller;

import javax.servlet.http.HttpServletRequest;

import com.mock.common.response.utils.Response;
import com.mock.common.response.utils.Response.FailureResponse;
import com.mock.common.response.utils.ResponseCode;
import com.mock.server.service.RequestHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handle All the Requests here
 */
@Controller
public class RequestHandlerController {

	@Autowired
	RequestHandlerService service;

	@RequestMapping(value = "/**", method = RequestMethod.GET)
	public @ResponseBody
	ResponseEntity handleGetRequest(HttpServletRequest request, @RequestHeader("Http-Mock-Config-File") String configFilePath) {

		try {

			Response response = service.handleRequest(request, configFilePath);
			HttpHeaders headers = new HttpHeaders();
			response.headers.entrySet().forEach(e -> headers.add(e.getKey(), e.getValue()));
			if (response.code == 0) {

				return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response.getSuccessfulResponse());
			} else {

				return ResponseEntity.status(response.status).body(response.getFailureResponse());
			}
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FailureResponse(
					ResponseCode.INTERNAL_SERVER_ERROR));
		}
	}

	@RequestMapping(value = "/**", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity handlePostRequest(HttpServletRequest request, @RequestHeader("Http-Mock-Config-File") String configFilePath) {

		try {

			Response response = service.handleRequest(request, configFilePath);
			HttpHeaders headers = new HttpHeaders();
			response.headers.entrySet().forEach(e -> headers.add(e.getKey(), e.getValue()));
			if (response.code == 0) {

				return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response.getSuccessfulResponse());
			} else {

				return ResponseEntity.status(response.status).body(response.getFailureResponse());
			}
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FailureResponse(
					ResponseCode.INTERNAL_SERVER_ERROR));
		}
	}

	@RequestMapping(value = "/**", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity handlePutRequest(HttpServletRequest request, @RequestHeader("Http-Mock-Config-File") String configFilePath) {

		try {

			Response response = service.handleRequest(request, configFilePath);
			HttpHeaders headers = new HttpHeaders();
			response.headers.entrySet().forEach(e -> headers.add(e.getKey(), e.getValue()));
			if (response.code == 0) {

				return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response.getSuccessfulResponse());
			} else {

				return ResponseEntity.status(response.status).body(response.getFailureResponse());
			}
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FailureResponse(
					ResponseCode.INTERNAL_SERVER_ERROR));
		}
	}
}
