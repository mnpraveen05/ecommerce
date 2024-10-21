package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.model.TrackingDetail;
import com.ecommerce.serviceimpl.TrackingDetailServiceimpl;

@RestController
@RequestMapping("/api/trackingDetails")
public class TrackingDetailController {

	@Autowired
	private TrackingDetailServiceimpl trackingDetailService;

	@GetMapping
	public List<TrackingDetail> getAllTrackingDetail(TrackingDetail trackingDetail) {
		return trackingDetailService.getAllTrackingDetail();

	}

	@PostMapping("/createTrackingDetail")
	public ResponseEntity<TrackingDetail> createTrackingDetail(@RequestBody TrackingDetail trackingDetail) {
		try {
			System.out.println("TrackingDetail from request TrackingDetail.getName() :" + trackingDetail);
			TrackingDetail savedTrackingDetail = trackingDetailService.save(trackingDetail);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedTrackingDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}