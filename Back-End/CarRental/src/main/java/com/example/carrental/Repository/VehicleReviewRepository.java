package com.example.carrental.Repository;

import com.example.carrental.Entity.VehicleReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleReviewRepository extends JpaRepository<VehicleReview,Long> {
}
