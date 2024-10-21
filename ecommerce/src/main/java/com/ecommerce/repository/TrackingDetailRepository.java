package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.dto.TrackingDetailDto;
import com.ecommerce.model.TrackingDetail;
@Repository
public interface TrackingDetailRepository extends JpaRepository<TrackingDetail, Integer> {

	TrackingDetail save(TrackingDetail trackingDetail);


}
