package com.ecommerce.ServiceInterface;


import com.ecommerce.dto.TrackingDetailDto;
import com.ecommerce.model.TrackingDetail;


public interface TrackingDetailService {

	TrackingDetail createTrackingDetail(TrackingDetailDto trackingDetailDto);

}
