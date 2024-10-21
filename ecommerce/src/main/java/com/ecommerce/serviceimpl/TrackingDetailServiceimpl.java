package com.ecommerce.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.ecommerce.ServiceInterface.TrackingDetailService;
import com.ecommerce.dto.TrackingDetailDto;
import com.ecommerce.model.TrackingDetail;
import com.ecommerce.repository.TrackingDetailRepository;
@Service
@Primary
public class TrackingDetailServiceimpl implements TrackingDetailService{



	@Autowired
	private TrackingDetailRepository trackingDetailRepository;
	
	public List<TrackingDetail> getAllTrackingDetail() {
    return  trackingDetailRepository.findAll();
    }

	
	  

	public TrackingDetail save(TrackingDetail trackingDetail) {
		 return trackingDetailRepository.save(trackingDetail);
	}




	@Override
	public TrackingDetail createTrackingDetail(TrackingDetailDto trackingDetailDto) {
		// TODO Auto-generated method stub
		return null;
	}

}

